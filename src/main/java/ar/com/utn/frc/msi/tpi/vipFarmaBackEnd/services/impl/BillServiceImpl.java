package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.BillEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Bill;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.BillItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Tax;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.TaxType;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.BillRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.RollbackException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BillServiceImpl extends BaseModelServiceImpl<Bill, BillEntity> implements BillService {

    private static final Long daysToDueDate = 1L;
    private final BillRepository billRepository;

    private final UserService userService;
    private final TaxService taxService;

    private final SaleOrderService saleOrderService;

    private final BillItemService billItemService;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.billRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Override
    @Transactional
    public Bill billOrder(Long id, Long userId, Boolean preview) {
        SaleOrder saleOrder = saleOrderService.getById(id);
        Bill bill = new Bill();
        bill.setOrderId(id);
        bill.setCreatedDate(LocalDate.now());
        bill.setDueDate(this.getDueDate());
        bill.setCustomer(saleOrder.getCustomer());
        User user = userService.getById(userId);
        if(user == null) {
            throw new EntityNotFoundException(String.format("%s id %s not found", "User", userId));
        }
        bill.setUser(user);
        if(!preview) {
            // Si es una preview, no grab los datos en la base
            bill = this.create(bill);
        }

        List<BillItem> billItemList = new LinkedList<>();
        for(SaleOrderItem item : saleOrder.getSaleOrderItems()) {
            billItemList.add(billItemService.billingItem(item, bill.getId()));
        }

        this.calculateTaxes(billItemList, bill.getId());
        if(!preview) {
            // Si es una preview, no grab los datos en la base
            billItemList = billItemService.createAll(billItemList);
        }

        bill.setTotalAmount(this.getTotalAmount(billItemList));
        bill.setItems(billItemList);

        bill.setCae(this.getCae());

        if(!preview) {
            // Si es una preview, no grabo los datos en la base
            saleOrderService.changeStatus(id, SaleOrderStatus.BILLED);
        }

        return bill;
    }

    @Override
    public List<Bill> getAllBills() {
        List<Bill> bills = this.getAll();
        for(Bill b : bills) {
            b.setTotalAmount(this.getTotalAmount(b.getItems()));
        }
        return bills;
    }

    private BigDecimal getTotalAmount(List<BillItem> billItemList) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for(BillItem item : billItemList) {
            totalAmount = totalAmount.add(item.getTotalPrice()).setScale(2, RoundingMode.HALF_UP);
        }
        return totalAmount;
    }

    private void calculateTaxes(List<BillItem> billItemList, Long billId) {
        Tax tax = taxService.getTaxByTaxType(TaxType.VAT);
        BillItem taxesItem = new BillItem();
        taxesItem.setBillId(billId);
        taxesItem.setQuantity(1);
        taxesItem.setLabelInvoice(tax.getLabelInvoice());
        BigDecimal taxAmount = BigDecimal.ZERO;
        for(BillItem item : billItemList) {
            taxAmount = taxAmount.add(this.calculateTax(item, tax));
        }
        taxesItem.setUnitaryPrice(taxAmount);
        taxesItem.setTotalPrice(taxAmount.setScale(2, RoundingMode.HALF_UP));
        billItemList.add(taxesItem);
    }

    private BigDecimal calculateTax(BillItem item, Tax tax) {
        return item.getUnitaryPrice().setScale(2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(item.getQuantity()))
                .multiply(tax.getTaxValue());
    }

    private String getCae() {
        return "1234567891234567890";
    }

    private LocalDate getDueDate() {
        return LocalDate.now().plusDays(daysToDueDate);
    }
}

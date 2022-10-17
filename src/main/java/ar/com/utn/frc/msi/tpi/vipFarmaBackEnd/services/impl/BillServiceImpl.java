package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.BillEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Bill;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.BillItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Tax;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.TaxType;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.BillRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.BillItemService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.BillService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.SaleOrderService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.TaxService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BillServiceImpl extends BaseModelServiceImpl<Bill, BillEntity> implements BillService {

    private final BillRepository billRepository;

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
    public Bill billOrder(Long id, Long userId) {
        SaleOrder saleOrder = saleOrderService.getById(id);
        Bill bill = new Bill();
        bill.setOrderId(saleOrder.getId());
        bill.setCreatedDate(LocalDate.now());
        bill.setDueDate(this.getDueDate());
        bill.setCustomer(saleOrder.getCustomer());
        // TODO - Pedir el usuario en el controller y trasladarlo a la factura.
        bill.setUser(null);
        bill = this.create(bill);

        List<BillItem> billItemList = new LinkedList<>();
        for(SaleOrderItem item : saleOrder.getSaleOrderItems()) {
            billItemList.add(billItemService.billingItem(item, bill.getId()));
        }

        this.calculateTaxes(billItemList, bill.getId());
        billItemList = billItemService.createAll(billItemList);

        bill.setItems(billItemList);

        bill.setCae(this.getCae());
        return bill;
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
        taxesItem.setTotalPrice(taxAmount);
        billItemList.add(taxesItem);
    }

    private BigDecimal calculateTax(BillItem item, Tax tax) {
        return item.getTotalPrice().multiply(tax.getTaxValue());
    }

    private String getCae() {
        return "1234567891234567890";
    }

    private LocalDate getDueDate() {
        return LocalDate.now().plusDays(1L);
    }
}

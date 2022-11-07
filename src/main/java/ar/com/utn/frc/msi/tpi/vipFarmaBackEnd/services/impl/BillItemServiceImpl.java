package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.BillItemEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.BillItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Tax;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.TaxType;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.BillItemRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.BillItemService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.TaxService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
@RequiredArgsConstructor
public class BillItemServiceImpl extends BaseModelServiceImpl<BillItem, BillItemEntity> implements BillItemService {

    private final BillItemRepository billItemRepository;

    private final TaxService taxService;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.billItemRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }


    public BillItem billingItem(SaleOrderItem item, Long billId) {
        Tax tax = taxService.getTaxByTaxType(TaxType.VAT);
        BillItem billItem = new BillItem();
        billItem.setOffer(item.getOffer());
        billItem.setLabelInvoice(item.getOffer().getProduct().getName());
        billItem.setQuantity(item.getQuantity());
        billItem.setUnitaryPrice(calculateTaxFreePrice(item, tax));
        billItem.setDiscountAmount(item.getDiscountAmount());
        billItem.setTotalPrice(calculateTotalPrice(billItem));
        billItem.setBillId(billId);
        return billItem;
    }

    private BigDecimal calculateTaxFreePrice(SaleOrderItem item, Tax tax) {
        return item.getTotalPrice().divide(BigDecimal.ONE.add(tax.getTaxValue()), RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTotalPrice(BillItem item) {
//        return item.getTotalPrice()
//                .multiply(BigDecimal.valueOf(item.getQuantity()))
//                .divide(BigDecimal.ONE.add(tax.getTaxValue()), RoundingMode.HALF_UP)
//                .subtract(item.getDiscountAmount());
        BigDecimal totalWithOutDiscount = item.getUnitaryPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
        return (item.getDiscountAmount() != null)? totalWithOutDiscount.subtract(item.getDiscountAmount()):totalWithOutDiscount;
    }

    private BigDecimal calculateDiscountPrice(SaleOrderItem item, Tax tax) {
        return item.getTotalPrice().divide(BigDecimal.ONE.add(tax.getTaxValue()), RoundingMode.HALF_UP);
    }
}

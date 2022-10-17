package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.BillItemEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.BillItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderItem;
import org.springframework.stereotype.Repository;

public interface BillItemService extends BaseModelService<BillItem, BillItemEntity> {

    BillItem billingItem(SaleOrderItem item, Long billId);
}

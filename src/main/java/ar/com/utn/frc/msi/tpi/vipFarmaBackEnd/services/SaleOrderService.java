package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.SaleOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;

import java.util.List;

public interface SaleOrderService extends BaseModelService<SaleOrder, SaleOrderEntity> {
    
    List<SaleOrder> getOrdersByStatusAndBranchOffice(SaleOrderStatus saleOrderStatus, Long branchOfficeId);

    SaleOrder changeStatus(Long id, SaleOrderStatus saleOrderStatus);

}

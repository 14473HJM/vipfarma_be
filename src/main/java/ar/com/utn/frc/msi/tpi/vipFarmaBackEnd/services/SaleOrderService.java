package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;

import java.util.List;

public interface SaleOrderService {

    SaleOrder createOrder(SaleOrder saleOrder);
    
    List<SaleOrder> getOrders(String saleOrderStatus, Long branchOfficeId);

    SaleOrder changeStatus(Long id, String saleOrderStatus);

    SaleOrder changeOrder(Long id, SaleOrder saleOrder);

    SaleOrder getOrder(Long id);
}

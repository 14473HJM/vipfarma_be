package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.SaleOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrderStatus;

import java.util.List;

public interface StockOrderService extends BaseModelService<StockOrder, StockOrderEntity> {

    List<StockOrder> getOrdersByStatusAndWarehouse(StockOrderStatus stockOrderStatus, Long warehouseId);

    StockOrder changeStatus(Long id, StockOrderStatus stockOrderStatus);
}

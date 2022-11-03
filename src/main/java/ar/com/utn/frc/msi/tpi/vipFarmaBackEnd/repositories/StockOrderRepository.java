package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.WarehouseEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockOrderRepository extends JpaRepository<StockOrderEntity, Long> {

    List<StockOrderEntity> getByStockOrderStatusAndWarehouseId(StockOrderStatus stockOrderStatus, WarehouseEntity warehouse);
}

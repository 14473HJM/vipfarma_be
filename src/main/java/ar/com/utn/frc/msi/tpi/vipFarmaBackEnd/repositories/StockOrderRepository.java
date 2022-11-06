package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.WarehouseEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockOrderRepository extends JpaRepository<StockOrderEntity, Long> {

    List<StockOrderEntity> getByStockOrderStatusAndWarehouseId(StockOrderStatus stockOrderStatus, WarehouseEntity warehouse);
    @Query("SELECT S " +
            "FROM stockOrders S " +
            "WHERE S.warehouseId.branchOffice.id = :branchOfficeId " +
            "AND S.stockOrderStatus = :stockOrderStatus ")
    List<StockOrderEntity> getByStockOrderStatusAndBranchOffice(StockOrderStatus stockOrderStatus, Long branchOfficeId);
}

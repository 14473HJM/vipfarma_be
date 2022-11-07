package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockSummaryEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Stock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

    List<StockEntity> getStockEntityByProductId(Long productId);

    @Query("SELECT S " +
            "FROM stocks S, lockers L " +
            "WHERE S.lockerId = L " +
            "AND S.productId.id = :productId " +
            "AND L.branchOfficeId.id = :branchOfficeId " +
            "ORDER BY S.dueDate ASC")
    List<StockEntity> getStockEntityByProductIdAndBranchOfficeId(Long productId, Long branchOfficeId);

    @Query("SELECT new ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockSummaryEntity(S.stockStatus, SUM(S.availableStock)) " +
            "FROM stocks S " +
            "GROUP BY S.stockStatus")
    List<StockSummaryEntity> getStockSummaryByStatusGrouped();

    @Query("SELECT new ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockSummaryEntity(S.productId, S.stockStatus, SUM(S.availableStock)) " +
            "FROM stocks S " +
            "WHERE S.stockStatus = :status " +
            "AND S.productId.id = :productId " +
            "GROUP BY S.stockStatus, S.productId")
    List<StockSummaryEntity> getStockSummaryByStatusAndProduct(StockStatus status, Long productId);

    @Query("SELECT new ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockSummaryEntity(S.lockerId, SUM(S.availableStock)) " +
            "FROM stocks S " +
            "WHERE S.lockerId.id = :lockerId " +
            "GROUP BY S.lockerId")
    List<StockSummaryEntity> getStockSummaryByLocker(Long lockerId);

    @Query("SELECT new ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockSummaryEntity(S.productId, S.stockStatus, SUM(S.availableStock)) " +
            "FROM stocks S " +
            "WHERE S.productId.id = :productId " +
            "GROUP BY S.stockStatus, S.productId")
    List<StockSummaryEntity> getStockSummaryByProduct(Long productId);

    @Query("SELECT new ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockSummaryEntity(S.productId, S.stockStatus, SUM(S.availableStock)) " +
            "FROM stocks S " +
            "WHERE S.stockStatus = :status " +
            "GROUP BY S.stockStatus, S.productId")
    List<StockSummaryEntity> getStockSummaryByStatus(StockStatus status);
}
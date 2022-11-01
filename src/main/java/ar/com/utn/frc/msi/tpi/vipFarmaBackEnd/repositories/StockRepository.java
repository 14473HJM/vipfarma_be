package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

    List<StockEntity> getStockEntityByProductId(Long productId);

    @Query("SELECT S.id, S.lockerId, S.availableStock, S.createdDate, S.dueDate, S.endDate, S.initialStock, S.productId, S.stockStatus " +
            "FROM stocks S, lockers L " +
            "WHERE S.lockerId = L " +
            "AND S.productId = :productId " +
            "AND L.branchOfficeId = :branchOfficeId " +
            "ORDER BY S.dueDate ASC")
    List<StockEntity> getStockEntityByProductIdAndBranchOfficeId(Long productId, Long branchOfficeId);
}

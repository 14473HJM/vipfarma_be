package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.LockerEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Locker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LockerRepository extends JpaRepository<LockerEntity, Long> {

    List<Locker> getAllByProductId(Long productId);

    @Query("SELECT L FROM lockers L " +
            "WHERE L.product.id = :productId " +
            "AND (L.stockCapacity - L.occupiedCapacity) > :availability")
    List<Locker> getAllByProductAndAvailability(Long productId, Integer availability);
}

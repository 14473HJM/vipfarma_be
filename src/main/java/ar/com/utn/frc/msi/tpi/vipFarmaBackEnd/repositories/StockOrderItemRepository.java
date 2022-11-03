package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockOrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockOrderItemRepository extends JpaRepository<StockOrderItemEntity, Long> {
}

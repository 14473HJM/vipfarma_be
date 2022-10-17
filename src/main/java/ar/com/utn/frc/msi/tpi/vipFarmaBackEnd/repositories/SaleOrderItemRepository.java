package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.SaleOrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleOrderItemRepository extends JpaRepository<SaleOrderItemEntity, Long> {
}

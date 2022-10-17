package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.BillItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillItemRepository extends JpaRepository<BillItemEntity, Long> {
}

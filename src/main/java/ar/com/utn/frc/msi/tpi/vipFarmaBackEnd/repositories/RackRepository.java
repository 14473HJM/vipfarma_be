package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.RackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackRepository extends JpaRepository<RackEntity, Long> {


}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.HealthInsurancePlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthInsurancePlanRepository extends JpaRepository<HealthInsurancePlanEntity, Long> {

    List<HealthInsurancePlanEntity> findByHealthInsuranceId(Long id);
}

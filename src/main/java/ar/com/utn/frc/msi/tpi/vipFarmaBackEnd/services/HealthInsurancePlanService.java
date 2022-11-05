package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.HealthInsurancePlanEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;

import java.util.List;

public interface HealthInsurancePlanService extends BaseModelService<HealthInsurancePlan, HealthInsurancePlanEntity> {

    List<HealthInsurancePlan> getByInsurance(Long insuranceId);
}

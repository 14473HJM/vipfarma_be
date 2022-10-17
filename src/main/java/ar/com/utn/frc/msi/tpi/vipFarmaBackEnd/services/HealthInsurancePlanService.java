package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;

import java.util.List;

public interface HealthInsurancePlanService {

    HealthInsurancePlan createHealthInsurancePlan(HealthInsurancePlan healthInsurancePlan);

    HealthInsurancePlan updateHealthInsurancePlan(HealthInsurancePlan healthInsurancePlan);

    HealthInsurancePlan getById(Long id);

    List<HealthInsurancePlan> getAll();
    
}

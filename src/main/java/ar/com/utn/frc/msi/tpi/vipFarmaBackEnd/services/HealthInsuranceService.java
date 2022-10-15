package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;

import java.util.List;

public interface HealthInsuranceService {

    HealthInsurance createHealthInsurance(HealthInsurance healthInsurance);

    List<HealthInsurance> getHealthInsurances();

    HealthInsurance getById(Long id);
}

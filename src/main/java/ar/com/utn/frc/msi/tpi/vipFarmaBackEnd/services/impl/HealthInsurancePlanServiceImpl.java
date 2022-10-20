package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.HealthInsuranceEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.HealthInsurancePlanEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.HealthInsurancePlanRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.HealthInsurancePlanService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class HealthInsurancePlanServiceImpl extends BaseModelServiceImpl<HealthInsurancePlan, HealthInsurancePlanEntity> implements HealthInsurancePlanService {

    private final HealthInsurancePlanRepository healthInsurancePlanRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.healthInsurancePlanRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }

}

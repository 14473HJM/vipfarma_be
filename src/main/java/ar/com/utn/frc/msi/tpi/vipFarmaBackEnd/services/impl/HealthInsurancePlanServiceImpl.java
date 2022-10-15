package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.HealthInsuranceEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.HealthInsurancePlanEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.HealthInsurancePlanRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.HealthInsurancePlanService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class HealthInsurancePlanServiceImpl implements HealthInsurancePlanService {

    private final HealthInsurancePlanRepository healthInsurancePlanRepository;

    private final ModelMapper modelMapper;

    @Override
    public HealthInsurancePlan createHealthInsurancePlan(HealthInsurancePlan healthInsurancePlan) {
        HealthInsurancePlanEntity healthInsurancePlanEntity = modelMapper.map(healthInsurancePlan, HealthInsurancePlanEntity.class);
        healthInsurancePlanEntity = healthInsurancePlanRepository.save(healthInsurancePlanEntity);
        return modelMapper.map(healthInsurancePlanEntity, HealthInsurancePlan.class);
    }

    @Override
    public HealthInsurancePlan updateHealthInsurancePlan(HealthInsurancePlan healthInsurancePlan){
        // TODO HJM - Hay que guardar cambios o toda la entidad? COntrola el FrontEnd
        HealthInsurancePlanEntity healthInsurancePlanEntity = modelMapper.map(healthInsurancePlan, HealthInsurancePlanEntity.class);
        healthInsurancePlanEntity = healthInsurancePlanRepository.save(healthInsurancePlanEntity);
        return modelMapper.map(healthInsurancePlanEntity, HealthInsurancePlan.class);
    }

    @Override
    public HealthInsurancePlan getById(Long id){
        HealthInsurancePlanEntity healthInsurancePlanEntity = healthInsurancePlanRepository.getReferenceById(id);
        if(healthInsurancePlanEntity == null) {
            throw new EntityNotFoundException(String.format("HealthInsurancePlan id {} not found", id));
        } else {
            return modelMapper.map(healthInsurancePlanEntity, HealthInsurancePlan.class);
        }
    }

    @Override
    public List<HealthInsurancePlan> getAll(){
        List<HealthInsurancePlanEntity> entityList = healthInsurancePlanRepository.findAll();
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, HealthInsurancePlan.class))
                .collect(Collectors.toList());
    }
}

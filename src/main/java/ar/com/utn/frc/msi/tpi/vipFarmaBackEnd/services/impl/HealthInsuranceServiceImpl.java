package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.HealthInsuranceEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.HealthInsurancePlanEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.HealthInsuranceRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.HealthInsuranceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

    private final HealthInsuranceRepository healthInsuranceRepository;

    private final ModelMapper modelMapper;

    @Override
    public HealthInsurance createHealthInsurance(HealthInsurance healthInsurance) {
        HealthInsuranceEntity entity = modelMapper.map(healthInsurance, HealthInsuranceEntity.class);
        entity = healthInsuranceRepository.save(entity);
        return modelMapper.map(entity, HealthInsurance.class);
    }

    @Override
    public List<HealthInsurance> getHealthInsurances() {
        List<HealthInsuranceEntity> entityList = healthInsuranceRepository.findAll();
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, HealthInsurance.class))
                .collect(Collectors.toList());
    }

    @Override
    public HealthInsurance getById(Long id) {
        Optional<HealthInsuranceEntity> healthInsuranceEntityOptional = healthInsuranceRepository.findById(id);
        if(healthInsuranceEntityOptional.isEmpty()) {
            throw new EntityNotFoundException(String.format("HealthInsurance id {} not found", id));
        } else {
            return modelMapper.map(healthInsuranceEntityOptional.get(), HealthInsurance.class);
        }
    }
}

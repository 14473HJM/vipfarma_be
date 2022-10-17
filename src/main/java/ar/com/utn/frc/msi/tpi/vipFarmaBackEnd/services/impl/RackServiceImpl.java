package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.RackEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Rack;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.RackRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.WarehouseRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.RackService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RackServiceImpl extends BaseModelServiceImpl<Rack, RackEntity> implements RackService {

    private final RackRepository rackRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.rackRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.WarehouseEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Warehouse;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.BranchOfficeRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.WarehouseRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl extends BaseModelServiceImpl<Warehouse, WarehouseEntity> implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.warehouseRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}

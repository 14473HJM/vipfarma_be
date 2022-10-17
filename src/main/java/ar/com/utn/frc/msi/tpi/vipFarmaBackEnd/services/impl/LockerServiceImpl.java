package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.LockerEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Locker;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.LockerRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.RackRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.LockerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LockerServiceImpl extends BaseModelServiceImpl<Locker, LockerEntity> implements LockerService {

    private final LockerRepository lockerRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.lockerRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}

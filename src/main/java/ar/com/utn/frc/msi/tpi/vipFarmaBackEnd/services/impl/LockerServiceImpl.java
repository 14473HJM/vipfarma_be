package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.LockerEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Locker;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.LockerRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.RackRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.LockerService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public List<Locker> getAllByProduct(Long productId) {
        List<LockerEntity> entities = lockerRepository.getAllByProductId(productId);

        return entities.stream()
                .map(entity -> getModelMapper().map(entity, Locker.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Locker> getAllByProductAndAvailability(Long productId, Integer availability) {
        List<LockerEntity> entities = lockerRepository.getAllByProductAndAvailability(productId, availability);

        return entities.stream()
                .map(entity -> getModelMapper().map(entity, Locker.class))
                .collect(Collectors.toList());
    }
}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.BillItemEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.BillItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.BillItemRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.BillRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.BillItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BillItemServiceImpl extends BaseModelServiceImpl<BillItem, BillItemEntity> implements BillItemService {

    private final BillItemRepository billItemRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.billItemRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}

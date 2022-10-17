package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.BillEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Bill;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.BillRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.BranchOfficeRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.BillService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BillServiceImpl extends BaseModelServiceImpl<Bill, BillEntity> implements BillService {

    private final BillRepository billRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.billRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.ProductEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.TaxEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Tax;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.TaxType;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.TaxRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.TaxService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TaxServiceImpl extends BaseModelServiceImpl<Tax, TaxEntity> implements TaxService {


    private final TaxRepository taxRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.taxRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }


    public Tax getTaxByTaxType(TaxType taxType) {
        TaxEntity taxEntity = taxRepository.getByTaxType(taxType);
        return modelMapper.map(taxEntity, Tax.class);
    }
}

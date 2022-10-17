package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.SaleOrderItemEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.SaleOrderItemRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.StockRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.SaleOrderItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SaleOrderItemServiceImpl extends BaseModelServiceImpl<SaleOrderItem, SaleOrderItemEntity> implements SaleOrderItemService {

    private final SaleOrderItemRepository saleOrderItemRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.saleOrderItemRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}

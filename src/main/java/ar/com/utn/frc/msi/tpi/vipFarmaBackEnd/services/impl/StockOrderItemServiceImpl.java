package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockOrderEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockOrderItemEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.StockOrderItemRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.StockOrderRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.StockOrderItemService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.StockOrderService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.StockService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockOrderItemServiceImpl extends BaseModelServiceImpl<StockOrderItem, StockOrderItemEntity> implements StockOrderItemService {

    private final StockOrderItemRepository stockOrderItemRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository<StockOrderItemEntity, Long> getJpaRepository() {
        return stockOrderItemRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}

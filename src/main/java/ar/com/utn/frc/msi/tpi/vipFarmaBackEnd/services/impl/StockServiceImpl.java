package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Stock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.StockRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.StockService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl extends BaseModelServiceImpl<Stock, StockEntity> implements StockService {

    private final StockRepository stockRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.stockRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Override
    public List<Stock> getStockByProduct(Long productId) {
        List<StockEntity> stockEntityList = stockRepository.getStockEntityByProductId(productId);
        return stockEntityList.stream()
                .map(entity -> getModelMapper().map(entity, Stock.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Stock> getStockByProductAndBranchOffice(Long productId, Long branchOfficeId) {
        List<StockEntity> stockEntityList = stockRepository.getStockEntityByProductIdAndBranchOfficeId(productId, branchOfficeId);
        return stockEntityList.stream()
                .map(entity -> getModelMapper().map(entity, Stock.class))
                .collect(Collectors.toList());
    }

    @Override
    public Stock reserveStock(Product product) {
        return null;
    }
}

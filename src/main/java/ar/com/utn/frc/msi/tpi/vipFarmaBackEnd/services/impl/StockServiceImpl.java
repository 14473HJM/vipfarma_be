package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Stock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.StockRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.StockService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
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
    public List<Stock> reserveStock(Long productId, Long branchOfficeId, Integer quantity) {
        List<Stock> stockList = this.getStockByProductAndBranchOffice(productId, branchOfficeId);
        List<Stock> stocksToReserved = new LinkedList<>();
        Integer discountApplied = 0;
        for (Stock stock : stockList) {
            if(stock.getAvailableStock() > quantity) {
                // Si es mayor descuento pero no termino
                Stock reserveStock = copyStockToReserve(quantity, stock);
                reserveStock = create(reserveStock);
                Integer newStockAvailable = stock.getAvailableStock() - quantity;
                stock.setAvailableStock(newStockAvailable);
                update(stock);
                stocksToReserved.add(reserveStock);
                discountApplied += quantity;
            } else {
                // si no es mayor, es igual o menor, asi que lo termino
                Stock reserveStock = copyStockToReserve(quantity, stock);
                reserveStock = create(reserveStock);
                stock.setAvailableStock(0);
                stock.setStockStatus(StockStatus.INACTIVE);
                stock.setEndDate(LocalDate.now());
                update(stock);
                stocksToReserved.add(reserveStock);
                discountApplied += quantity;
            }
            if (discountApplied == quantity) {
                // si desconte el total, termino el bucle.
                break;
            }
        }
        return stocksToReserved;
    }

    @Override
    public void inactivateStocks(List<Stock> stocks) {
        stocks.forEach(stock -> {
            stock.setAvailableStock(0);
            stock.setStockStatus(StockStatus.INACTIVE);
            stock.setEndDate(LocalDate.now());
            update(stock);
        });
    }

    private Stock copyStockToReserve(Integer quantity, Stock stock) {
        Stock reserveStock = new Stock();
        reserveStock.setAvailableStock(quantity);
        reserveStock.setInitialStock(quantity);
        reserveStock.setStockStatus(StockStatus.RESERVED);
        reserveStock.setCreatedDate(LocalDate.now());
        reserveStock.setLocker(stock.getLocker());
        reserveStock.setDueDate(stock.getDueDate());
        reserveStock.setProduct(stock.getProduct());
        return reserveStock;
    }
}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Stock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockSummary;

import java.util.List;

public interface StockService extends BaseModelService<Stock, StockEntity> {

    List<Stock> getStockByProduct(Long productId);

    List<Stock> getStockByProductAndBranchOffice(Long productId, Long branchOfficeId);

    List<Stock> reserveStock(Long productId, Long branchOfficeId, Integer quantity);

    void inactivateStocks(List<Stock> stocks);

    List<StockSummary> getStockSummary(Long productId, StockStatus stockStatus, Long lockerId);

    List<StockSummary> getStockSummaryGrouped();
}

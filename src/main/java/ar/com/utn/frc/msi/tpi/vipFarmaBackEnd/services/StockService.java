package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Stock;

import java.util.List;

public interface StockService extends BaseModelService<Stock, StockEntity> {

    List<Stock> getStockByProduct(Long productId);

    List<Stock> getStockByProductAndBranchOffice(Long productId, Long branchOfficeId);

    Stock reserveStock(Product product);
}

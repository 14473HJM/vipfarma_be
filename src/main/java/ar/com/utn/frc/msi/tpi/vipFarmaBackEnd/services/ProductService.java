package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.ProductEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.OfferStock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;

import java.util.List;

public interface ProductService extends BaseModelService<Product, ProductEntity> {
    List<Product> getProductsByName(String name);

    Product getProductByBarcode(Long barcode);

    List<Product> getProductsByNameOrBarcode(String name, Long barcode);

    List<OfferStock> getProductStockByProductId(Long productId);

    List<OfferStock> getProductStockByProductIdAndBranchOffice(Long productId, Long branchOfficeId);

    List<OfferStock> getProductStockByBranchOffice(Long branchOfficeId);

}


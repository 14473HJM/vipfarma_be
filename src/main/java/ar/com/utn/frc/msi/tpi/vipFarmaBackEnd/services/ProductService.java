package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.ProductEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;

import java.util.List;

public interface ProductService extends BaseModelService<Product, ProductEntity> {
    List<Product> getProductsByName(String name);

    Product getProductByBarcode(Long barcode);

}


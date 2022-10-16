package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product); //reglas de creacion
    Product getProduct(Long id);
    List<Product> getProducts();
    List<Product> getProducts(String name, Long barcode); //si estan los dos busco por cb, solo nombre busca por name
    Product updateProduct(Product product);

}


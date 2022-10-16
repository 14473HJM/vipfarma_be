package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.ProductEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.ProductRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//id	name	barcode	laboratory	prescriptionRequired	price

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product getProduct(Long id) {
        ProductEntity productEntity = productRepository.getReferenceById(id);
        if(productEntity == null){
            throw new EntityNotFoundException(String.format("Product id {} not found", id));
        } else {
            return modelMapper.map(productEntity, Product.class);
        }
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public List<Product> getProducts(String name, Long barcode) {
        List<ProductEntity> productEntityList = new LinkedList();
        if (barcode==null)
            productEntityList.add(productRepository.getByNameContaining(name));
        else{
            productEntityList.add(productRepository.getByBarcode(barcode));
        }
        return productEntityList.stream().map(
                entity -> modelMapper.map(entity, Product.class)).collect(Collectors.toList());
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }
}

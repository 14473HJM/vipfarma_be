package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.ProductEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.OfferStock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.ProductRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//id	name	barcode	laboratory	prescriptionRequired	price

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BaseModelServiceImpl<Product,ProductEntity> implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.productRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }


    @Override
    public List<Product> getProductsByName(String name) {
        List<ProductEntity> productEntityList = productRepository.getByNameContaining(name);
        return productEntityList.stream()
                .map(entity -> getModelMapper().map(entity, Product.class))
                .collect(Collectors.toList());
    }

    @Override
    public Product getProductByBarcode(Long barcode) {
        ProductEntity productEntity = productRepository.getByBarcode(barcode);
        return modelMapper.map(productEntity, Product.class);
    }

    @Override
    public List<OfferStock> getProductStockByProductId(Long productId) {
        return null;
    }

    @Override
    public List<OfferStock> getProductStockByProductIdAndBranchOffice(Long productId, Long branchOfficeId) {
        return null;
    }

    @Override
    public List<OfferStock> getProductStockByBranchOffice(Long branchOfficeId) {
        return null;
    }
}

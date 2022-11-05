package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> getByNameContainingIgnoreCase(String name);
    List<ProductEntity> getByNameIgnoreCaseOrBarcode(String name, Long barcode);
    ProductEntity getByBarcode (Long barcode);
}

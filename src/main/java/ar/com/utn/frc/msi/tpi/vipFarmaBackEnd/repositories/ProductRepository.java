package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity getByNameContaining(String name);
    ProductEntity getByBarcode (Long barcode);
}

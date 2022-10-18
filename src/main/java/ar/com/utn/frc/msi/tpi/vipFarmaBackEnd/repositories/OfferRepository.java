package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OfferEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OfferStockEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.OfferStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    @Query("SELECT new ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OfferStockEntity(" +
            "O.id, O.product, O.healthInsurance, O.healthInsurancePlan, O.discountType, O.discountValue, SUM(L.currentStock)) " +
            "FROM offers O, lockers L " +
            "WHERE O.product = L.product " +
            "GROUP BY O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan")
    List<OfferStockEntity> getAllOffersWithStock();

    @Query("SELECT new ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OfferStockEntity(" +
            "O.id, O.product, O.healthInsurance, O.healthInsurancePlan, O.discountType, O.discountValue, SUM(L.currentStock)) " +
            "FROM offers O, lockers L " +
            "WHERE O.product = L.product " +
            "AND O.product = :productId " +
            "GROUP BY O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan")
    List<OfferStockEntity> getOfferStockByProductId(Long productId);

    @Query("SELECT new ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OfferStockEntity(" +
            "O.id, O.product, O.healthInsurance, O.healthInsurancePlan, O.discountType, O.discountValue, SUM(L.currentStock)) " +
            "FROM offers O, lockers L " +
            "WHERE O.product = L.product " +
            "AND O.product = :productId " +
            "AND L.branchOfficeId = :branchOfficeId " +
            "GROUP BY O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan")
    List<OfferStockEntity> getOfferStockByProductIdAndBranchOffice(Long productId, Long branchOfficeId);

    @Query("SELECT new ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OfferStockEntity(" +
            "O.id, O.product, O.healthInsurance, O.healthInsurancePlan, O.discountType, O.discountValue, SUM(L.currentStock)) " +
            "FROM offers O, lockers L " +
            "WHERE O.product = L.product " +
            "AND O.id = :id " +
            "GROUP BY O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan")
    OfferStockEntity getOfferByIdWithStock(Long id);
}

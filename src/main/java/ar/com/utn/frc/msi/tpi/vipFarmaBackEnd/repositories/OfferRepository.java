package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OfferEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.OfferStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    @Query("SELECT O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan, SUM(L.currentStock) " +
            "FROM offers O, lockers L " +
            "WHERE O.product = L.product " +
            "GROUP BY O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan")
    List<OfferStock> getAllOffersWithStock();

    @Query("SELECT O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan, SUM(L.currentStock) " +
            "FROM offers O, lockers L " +
            "WHERE O.product = L.product " +
            "AND O.product = :productId " +
            "GROUP BY O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan")
    List<OfferStock> getOfferStockByProductId(Long productId);

    @Query("SELECT O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan, SUM(L.currentStock) " +
            "FROM offers O, lockers L " +
            "WHERE O.product = L.product " +
            "AND O.product = :productId " +
            "AND L.branchOfficeId = :branchOfficeId " +
            "GROUP BY O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan")
    List<OfferStock> getOfferStockByProductIdAndBranchOffice(Long productId, Long branchOfficeId);

    @Query("SELECT O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan, SUM(L.currentStock) " +
            "FROM offers O, lockers L " +
            "WHERE O.product = L.product " +
            "AND O.id = :id " +
            "GROUP BY O.id, O.product, O.discountType, O.discountValue, O.healthInsurance, O.healthInsurancePlan")
    OfferStock getOfferByIdWithStock(Long id);
}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.SaleOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleOrderRepository extends JpaRepository <SaleOrderEntity, Long>  {
    List<SaleOrderEntity> getBySaleOrderStatusAndBranchOfficeId(String saleOrderStatus, Long branchOfficeId);

    SaleOrderEntity getByIdAndSaleOrderStatus(Long id, String saleOrderStatus);
}

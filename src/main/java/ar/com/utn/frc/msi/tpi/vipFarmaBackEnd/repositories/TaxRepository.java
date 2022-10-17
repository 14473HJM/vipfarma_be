package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.TaxEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.TaxType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<TaxEntity, Long> {

    TaxEntity getByTaxType(TaxType taxType);
}

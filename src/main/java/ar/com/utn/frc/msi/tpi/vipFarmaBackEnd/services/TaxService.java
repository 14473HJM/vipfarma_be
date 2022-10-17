package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.TaxEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Tax;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.TaxType;

public interface TaxService extends BaseModelService<Tax, TaxEntity> {

    Tax getTaxByTaxType(TaxType taxType);
}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OfferEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Offer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.OfferStock;

import java.util.List;

public interface OfferService extends BaseModelService<Offer, OfferEntity> {

    List<OfferStock> getAllOffersWithStock();

    OfferStock getOffersWithStock(Long id);
}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OfferEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.DiscountType;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Offer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.OfferStock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.OfferRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.OfferService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl extends BaseModelServiceImpl<Offer, OfferEntity> implements OfferService {

    private final OfferRepository offerRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.offerRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Override
    public Offer getById(Long id) {
        Offer offer = super.getById(id);
        offer.setFinalPrice(this.getFinalPrice(offer));
        return offer;
    }

    @Override
    public List<Offer> getAll() {
        List<Offer> offerList = super.getAll();
        for (Offer offer : offerList) {
            offer.setFinalPrice(this.getFinalPrice(offer));
        }
        return offerList;
    }

    @Override
    public List<OfferStock> getAllOffersWithStock() {
        List<OfferStock> offerStockList = offerRepository.getAllOffersWithStock();
        for (OfferStock offer : offerStockList) {
            offer.setFinalPrice(this.getFinalPrice(offer));
        }
        return offerStockList;
    }

    @Override
    public OfferStock getOffersWithStock(Long id) {
        return offerRepository.getOfferByIdWithStock(id);
    }

    @Override
    public List<OfferStock> getOfferStockByProductId(Long productId) {
        List<OfferStock> offerStockList = offerRepository.getOfferStockByProductId(productId);
        for (OfferStock offer : offerStockList) {
            offer.setFinalPrice(this.getFinalPrice(offer));
        }
        return offerStockList;
    }

    @Override
    public List<OfferStock> getOfferStockByProductIdAndBranchOffice(Long productId, Long branchOfficeId) {
        List<OfferStock> offerStockList = offerRepository.getOfferStockByProductIdAndBranchOffice(productId, branchOfficeId);
        for (OfferStock offer : offerStockList) {
            offer.setFinalPrice(this.getFinalPrice(offer));
        }
        return offerStockList;
    }

    private BigDecimal getFinalPrice(Offer offer) {
        if(offer.getDiscountType() == null) {
            return offer.getProduct().getPrice();
        } else {
            return this.applyDiscount(offer);
        }
    }

    private BigDecimal applyDiscount(Offer offer) {
        DiscountType discountType = offer.getDiscountType();
        switch (discountType) {
            case FIXED:
                return applyFixDiscount(offer.getProduct().getPrice(), offer.getDiscountValue());
            case PERCENTAGE:
                return applyPercentageDiscount(offer.getProduct().getPrice(), offer.getDiscountValue());
            case OVERRIDE:
                return applyOverrideDiscount(offer.getProduct().getPrice(), offer.getDiscountValue());
            default:
                return offer.getProduct().getPrice();
        }
    }

    private BigDecimal applyFixDiscount(BigDecimal price, BigDecimal value) {
        if(price.compareTo(value) > 0) {
            return price.subtract(value);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private BigDecimal applyPercentageDiscount(BigDecimal price, BigDecimal value) {
        if(value.signum() == 0) {
            return price;
        } else if(value.signum() == 1 && value.compareTo(BigDecimal.ONE) <= 0) {
            BigDecimal rate = BigDecimal.ONE.subtract(value);
            return price.multiply(rate).setScale(2, RoundingMode.HALF_UP);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private BigDecimal applyOverrideDiscount(BigDecimal price, BigDecimal value) {
        if(value.compareTo(BigDecimal.ZERO) >= 0) {
            return value;
        } else {
            return BigDecimal.ZERO;
        }
    }
}

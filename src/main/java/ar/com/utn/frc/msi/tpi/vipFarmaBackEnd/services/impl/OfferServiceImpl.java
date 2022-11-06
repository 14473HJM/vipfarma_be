package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OfferEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.OfferStockEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.DiscountType;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Offer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.OfferStock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.OfferRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.OfferService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        List<OfferStockEntity> offerStockEntityList = offerRepository.getAllOffersWithStock();
        return getOfferStockList(offerStockEntityList);
    }

    @Override
    public OfferStock getOffersWithStock(Long id) {
        OfferStockEntity offerStockEntity = offerRepository.getOfferByIdWithStock(id);
        return modelMapper.map(offerStockEntity, OfferStock.class);
    }

    @Override
    public List<OfferStock> getOfferStockByProductId(Long productId) {
        List<OfferStockEntity> offerStockEntityList = offerRepository.getOfferStockByProductId(productId);
        return getOfferStockList(offerStockEntityList);
    }

    @Override
    public List<OfferStock> getOfferStockByProductIdAndBranchOffice(Long productId, Long branchOfficeId) {
        List<OfferStockEntity> offerStockEntityList = offerRepository.getOfferStockByProductIdAndBranchOffice(productId, branchOfficeId);
        return getOfferStockList(offerStockEntityList);
    }

    @Override
    public OfferStock getOfferStockByProductIdAndBranchOfficeAndPlanId(Long productId, Long branchOfficeId, Long planId) {
        OfferStockEntity offerStockEntity = null;
        if(planId != null) {
            offerStockEntity = offerRepository
                    .getOfferByProductIdAndBranchIdAndPlanIdWithStock(productId, branchOfficeId, planId);
            if(offerStockEntity == null) {
                offerStockEntity = getOfferWithoutPlan(productId, branchOfficeId);
            }
        } else {
            offerStockEntity = getOfferWithoutPlan(productId, branchOfficeId);
        }

        if(offerStockEntity == null) {
            throw new EntityNotFoundException("No Hay Oferta para ese Producto");
        }

        return modelMapper.map(offerStockEntity, OfferStock.class);
    }

    @Override
    public List<OfferStock> getOfferStockByBranchOffice(Long branchOfficeId) {
        List<OfferStockEntity> offerStockEntityList = offerRepository.getOfferStockByBranchOffice(branchOfficeId);
        return getOfferStockList(offerStockEntityList);
    }

    private List<OfferStock> getOfferStockList(List<OfferStockEntity> offerStockEntityList) {
        List<OfferStock> offerStockList = offerStockEntityList.stream()
                .map(entity -> modelMapper.map(entity, OfferStock.class))
                .collect(Collectors.toList());
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

    private OfferStockEntity getOfferWithoutPlan(Long prodId, Long branchId) {
        return offerRepository.getOfferByProductIdAndBranchIdAndNullPlanWithStock(prodId, branchId);
    }
}

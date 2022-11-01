package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferStockEntity {

    private Long id;
    private ProductEntity product;
    private HealthInsuranceEntity healthInsurance;
    private HealthInsurancePlanEntity healthInsurancePlan;
    private String discountType;
    private BigDecimal discountValue;
    private Long stock;
}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "offers")
public class OfferEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "productId")
    private ProductEntity product;

    @OneToOne
    @JoinColumn(name = "healthInsuranceId")
    private HealthInsuranceEntity healthInsurance;

    @OneToOne
    @JoinColumn(name = "healthInsurancePlanId")
    private HealthInsurancePlanEntity healthInsurancePlan;

    private String discountType;

    private BigDecimal discountValue;
}

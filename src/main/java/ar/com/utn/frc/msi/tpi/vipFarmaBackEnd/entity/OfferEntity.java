package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "offers")
public class OfferEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "productId")
    private ProductEntity product;

    @OneToOne
    @JoinColumn(name = "hiId")
    private HealthInsuranceEntity healthInsuranceEntity;

    @OneToOne
    @JoinColumn(name = "hipId")
    private HealthInsurancePlanEntity healthInsurancePlanId;

    private String discountType;

    private BigDecimal discountValue;
}

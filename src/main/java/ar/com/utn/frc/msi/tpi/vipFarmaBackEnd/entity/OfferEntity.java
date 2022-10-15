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
    private Long productId;

    @OneToOne
    @JoinColumn(name = "heId")
    private HealthInsuranceEntity healthInsuranceEntity;
    private Long healthInsurancePlanId;
    private String discountType;
    private BigDecimal discountValue;
}

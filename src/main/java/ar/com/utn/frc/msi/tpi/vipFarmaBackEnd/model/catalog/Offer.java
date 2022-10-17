package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {

    private Long id;
    private Product product;
    private HealthInsurance healthInsurance;
    private HealthInsurancePlan healthInsurancePlan;
    private String discountType;
    private BigDecimal discountValue;
    private BigDecimal finalPrice;
}

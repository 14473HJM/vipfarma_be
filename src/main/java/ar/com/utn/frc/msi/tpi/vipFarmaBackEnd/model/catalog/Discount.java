package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Discount {

    private DiscountType discountType;
    private BigDecimal value;

}

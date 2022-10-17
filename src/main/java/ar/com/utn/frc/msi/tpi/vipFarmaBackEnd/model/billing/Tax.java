package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tax {

    private Long id;
    private TaxType taxType;
    private String labelInvoice;
    private BigDecimal taxValue;

}

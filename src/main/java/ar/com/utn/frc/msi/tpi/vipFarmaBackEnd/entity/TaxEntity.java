package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.TaxType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "taxes")
public class TaxEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TaxType taxType;
    private String labelInvoice;
    private BigDecimal taxValue;
}

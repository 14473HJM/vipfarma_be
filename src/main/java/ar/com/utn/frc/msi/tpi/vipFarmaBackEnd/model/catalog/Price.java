package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Price {

    private Long id;
    private Integer version;
    private BigDecimal price;
    private LocalDate validFrom;
    private LocalDate validTo;
}
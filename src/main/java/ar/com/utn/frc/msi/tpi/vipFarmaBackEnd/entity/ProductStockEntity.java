package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockEntity {

    private Long id;
    private String name;
    private Long barcode;
    private String laboratory;
    private Boolean prescriptionRequired;
    private BigDecimal price;
    private Long stock;
}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private Long barcode;
    private String laboratory;
    private Boolean prescriptionRequired;
    private Price price;

}

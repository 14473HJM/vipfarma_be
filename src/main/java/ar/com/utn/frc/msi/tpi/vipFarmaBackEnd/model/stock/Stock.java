package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stock {

    private Long id;
    private Product product;
    private Integer currentStock;

}

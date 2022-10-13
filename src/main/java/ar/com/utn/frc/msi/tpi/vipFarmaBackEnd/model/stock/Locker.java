package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locker {

    private Long id;
    private Long rackId;
    private Product product;
    private Integer stockCapacity;
    private Integer occupiedCapacity;
    private Integer currentStock;
}

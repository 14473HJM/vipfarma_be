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

    /**
     *  Este atributo guarda la ocupacion total del locker.
     *  Ocupacion = Stock disponible + stock vencido o roto (por retirar)
     */
    private Integer occupiedCapacity;

    /**
     *  Este atributo guarda la ocupacion disponible para la venta del locker.
     *  Ocupacion = Stock disponible - stock vencido o roto (por retirar)
     *
     *  Este campo es el que se mantendra actualizado con el stock real TOTAL de un producto para un Rack/Warehouse
     */
    private Integer currentStock;
    private Long branchOfficeId;
}

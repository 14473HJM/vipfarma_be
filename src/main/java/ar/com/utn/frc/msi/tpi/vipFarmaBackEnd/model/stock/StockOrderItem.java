package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockOrderItem {

    private Long id;
    private Long stockOrderId;
    private Product product;
    private Integer requiredQuantity;
    private Integer receivedQuantity;
    private Integer rejectedQuantity;
    private Integer actualQuantity;
    private StockOrderItemStatus stockOrderItemStatus;
    private List<Locker> lockersToSave;

}

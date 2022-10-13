package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockOrderItem {

    private Long id;
    private Long stockOrderId;
    private Product product;
    private Integer requiredQuantity;
    private Integer receivedQuantity;
    private Integer rejectedQuantity;
    private Integer actualQuantity;
    private StockOrderItemStatus stockOrderItemStatus;

}

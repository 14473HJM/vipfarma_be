package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrderItemStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "stockOrderItem")
public class StockOrderItemEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long stockOrderId;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private ProductEntity productId;

    private Integer requiredQuantity;
    private Integer receivedQuantity;
    private Integer rejectedQuantity;
    private Integer actualQuantity;

    @Enumerated(EnumType.STRING)
    private StockOrderItemStatus stockOrderItemStatus;
}

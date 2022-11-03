package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Stock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrderItemStatus;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "stockOrderItemsLockers",
            joinColumns = @JoinColumn(name = "stockOrderItemId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lockerId", referencedColumnName = "id"))
    private List<LockerEntity> lockersToSave;
}

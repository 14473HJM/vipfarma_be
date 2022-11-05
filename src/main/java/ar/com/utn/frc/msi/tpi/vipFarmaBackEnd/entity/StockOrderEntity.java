package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "stockOrders")
public class StockOrderEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long purchaseOrderId;

    @ManyToOne
    @JoinColumn(name = "warehouseId", referencedColumnName = "id")
    private WarehouseEntity warehouseId;

    private LocalDate createdDate;
    private LocalDate endDate;


    @Enumerated(EnumType.STRING)
    private StockOrderStatus stockOrderStatus;

    private String statusReason;
    private String statusComment;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "stockOrderId")
    private List<StockOrderItemEntity> stockOrderItems;
}

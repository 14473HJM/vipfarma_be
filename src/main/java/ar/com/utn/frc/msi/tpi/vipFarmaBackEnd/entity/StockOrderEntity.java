package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "stockOrder")
public class StockOrderEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "saleOrderId")
    private SaleOrderEntity saleOrderId;

    @ManyToOne
    @JoinColumn(name = "warehouseId", referencedColumnName = "id")
    private WarehouseEntity warehouseId;

    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private StockOrderStatus stockOrderStatus;
}

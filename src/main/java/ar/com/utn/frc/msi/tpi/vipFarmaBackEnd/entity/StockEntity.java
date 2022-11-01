package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Locker;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "stocks")
public class StockEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private ProductEntity productId;

    private LocalDate createdDate;
    private LocalDate endDate;
    private LocalDate dueDate;
    private Integer initialStock;
    private Integer availableStock;

    @OneToOne
    @JoinColumn(name = "lockerId", referencedColumnName = "id")
    private LockerEntity lockerId;

    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;
}

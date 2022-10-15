package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Locker;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Warehouse;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "racks")
public class RackEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "warehouseId", referencedColumnName = "id")
    private WarehouseEntity warehouse;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rack")
    private List<LockerEntity> lockers;

}

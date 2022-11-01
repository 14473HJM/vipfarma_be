package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Locker;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Warehouse;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "racks")
public class RackEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    @JoinColumn(name = "warehouseId", referencedColumnName = "id")
    private Long warehouseId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rackId")
    @Fetch(FetchMode.SELECT)
    private List<LockerEntity> lockers;
}

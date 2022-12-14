package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "warehouses")
public class WarehouseEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;

    @OneToOne
    @JoinColumn(name = "branchOfficeId", referencedColumnName = "id")
    private BranchOfficeEntity branchOffice;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "warehouseId")
    @Fetch(FetchMode.SELECT)
    private List<RackEntity> racks;
}

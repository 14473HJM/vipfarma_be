package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "warehouses")
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;

    @OneToOne
    @JoinColumn(name = "branchOfficeId", referencedColumnName = "id")
    private BranchOfficeEntity branchOffice;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "warehouse")
    private List<RackEntity> racks;
}

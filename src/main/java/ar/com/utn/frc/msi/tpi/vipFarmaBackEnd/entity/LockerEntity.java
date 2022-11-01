package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common.BranchOffice;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Rack;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "lockers")
public class LockerEntity extends Deleteable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "rackId", referencedColumnName = "id")
    private Long rackId;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private ProductEntity product;
    private Integer stockCapacity;
    private Integer occupiedCapacity;
    private Integer currentStock;

    @OneToOne
    @JoinColumn(name = "branchOfficeId", referencedColumnName = "id")
    private BranchOfficeEntity branchOfficeId;
}

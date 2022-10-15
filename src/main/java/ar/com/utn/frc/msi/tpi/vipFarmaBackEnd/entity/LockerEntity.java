package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Rack;

import javax.persistence.*;
import java.util.List;

@Entity(name = "lockers")
public class LockerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rackId", referencedColumnName = "id")
    private RackEntity rack;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private ProductEntity product;
    private Integer stockCapacity;

    //TODO MS Aguardar que AS suba su branch ya que contiene ProductEntity. Realizar relacion @ManyToOne
    //    @JoinColumn(name = "productId")
    //    private LockerEntity locker;
    //
}

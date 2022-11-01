package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "branchOffice")
public class BranchOfficeEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
}

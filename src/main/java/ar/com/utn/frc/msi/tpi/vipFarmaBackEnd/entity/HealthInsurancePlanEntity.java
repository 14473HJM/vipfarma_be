package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "healthIPlan")
public class HealthInsurancePlanEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="healthInsuranceId")
    private HealthInsuranceEntity healthInsuranceId;
}

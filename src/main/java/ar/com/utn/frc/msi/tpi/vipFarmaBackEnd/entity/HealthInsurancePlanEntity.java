package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "healthInsurancePlan")
public class HealthInsurancePlanEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @JoinColumn(name="healthInsuranceId")
    private Long healthInsuranceId;
}

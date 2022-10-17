package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "healthInsurance")
public class HealthInsuranceEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String number;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "healthInsuranceId")
    private List<HealthInsurancePlanEntity> availablePlans;
}

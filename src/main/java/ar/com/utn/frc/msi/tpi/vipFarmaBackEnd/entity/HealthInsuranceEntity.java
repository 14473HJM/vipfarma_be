package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "healthI")
public class HealthInsuranceEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String number;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "healthInsuranceId", cascade = CascadeType.ALL)
    private List<HealthInsurancePlanEntity> availablePlans;
}

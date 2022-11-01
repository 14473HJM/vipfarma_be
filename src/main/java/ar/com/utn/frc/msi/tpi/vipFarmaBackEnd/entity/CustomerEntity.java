package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.IdentificationType;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "customers")
public class CustomerEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String identificationType;
    private String identification;
    private String address;

    @OneToOne
    @JoinColumn(name = "healthInsuranceId")
    private HealthInsuranceEntity healthInsuranceId;

    @OneToOne
    @JoinColumn(name = "healthInsurancePlanId")
    private HealthInsurancePlanEntity healthInsurancePlanId;

}

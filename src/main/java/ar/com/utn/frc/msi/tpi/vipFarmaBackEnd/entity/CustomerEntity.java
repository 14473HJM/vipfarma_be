package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.IdentificationType;

import javax.persistence.*;


@Entity(name = "CustomerEntity")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String identificationType;
    private String identification;
    private String address;
    private Long healthInsurance;
    private Long healthInsurancePlan;

}

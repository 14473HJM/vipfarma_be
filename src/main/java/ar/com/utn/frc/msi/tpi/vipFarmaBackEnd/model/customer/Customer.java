package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private Long id;
    private String name;
    private String lastName;
    private IdentificationType identificationType;
    private String identification;
    private String address;
    private HealthInsurance healthInsurance;
    private HealthInsurancePlan healthInsurancePlan;
}

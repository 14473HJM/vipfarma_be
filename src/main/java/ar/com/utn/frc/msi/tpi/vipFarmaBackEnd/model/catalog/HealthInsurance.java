package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HealthInsurance {

    private Long id;
    private String name;
    private String number;
    private List<HealthInsurancePlan> availablePlans;
}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthInsurance {

    private Long id;

    @NotEmpty
    private String name;
    private String number;
    private List<HealthInsurancePlan> availablePlans;
}

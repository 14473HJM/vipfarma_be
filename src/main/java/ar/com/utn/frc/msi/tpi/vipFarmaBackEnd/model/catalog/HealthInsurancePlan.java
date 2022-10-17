package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthInsurancePlan {

    private Long id;

    @NotEmpty
    private String name;
    private String description;

    @NotEmpty
    private Long healthInsuranceId;
}

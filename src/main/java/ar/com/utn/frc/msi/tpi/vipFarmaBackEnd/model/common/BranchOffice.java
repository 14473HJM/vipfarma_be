package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchOffice {

    private Long id;
    private String name;
    private String location;
}

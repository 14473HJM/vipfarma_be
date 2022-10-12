package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchOffice {

    private Long id;
    private String name;
    private String location;
}

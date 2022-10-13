package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common.BranchOffice;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String userName;
    private String email;
    private String password;
    private UserRole userRoles;
    private BranchOffice branchOffice;

}

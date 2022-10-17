package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common.BranchOffice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String userName;
    private String email;
    private String password;
    private UserRole userRole;
    private BranchOffice branchOffice;

}

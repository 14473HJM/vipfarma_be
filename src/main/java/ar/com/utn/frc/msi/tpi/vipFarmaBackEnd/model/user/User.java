package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String userName;
    private String password;
    private List<UserRole> userRoles;

}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String userName;
    private String email;
    private String password;
    private String userRole;
    private Long branchOfficeId;
}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogged {

    @NotNull(message = "User identification must not by Null")
    @NotEmpty(message = "User identification must not by Empty")
    private Long id;
}

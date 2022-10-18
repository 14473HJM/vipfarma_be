package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.UserEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import org.springframework.stereotype.Service;

public interface UserService extends BaseModelService<User, UserEntity>{

    User login(String userName, String password);

}

package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User login(String userName, String password);

    User createUser(User user);

    User getUserById(Long userId);
}

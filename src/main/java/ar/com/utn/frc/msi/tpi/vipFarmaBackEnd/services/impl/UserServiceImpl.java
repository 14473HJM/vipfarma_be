package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.UserEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.UserRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public User login(String userName, String password) {
        UserEntity userEntity = userRepository.getByUserNameAndPassword(userName, password);
        if(userEntity != null) {
            User user = modelMapper.map(userEntity, User.class);
            return user;
        }
        return null;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity = userRepository.save(userEntity);
        return modelMapper.map(userEntity, User.class);
    }
}

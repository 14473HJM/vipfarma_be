package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.UserEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.UserRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

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
        throw new EntityNotFoundException("No se encontro ningun usuario");
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity = userRepository.save(userEntity);
        return modelMapper.map(userEntity, User.class);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if(userEntity.isPresent()) {
            return modelMapper.map(userEntity.get(), User.class);
        }
        throw new EntityNotFoundException("El usuario " + userId + " No existe");
    }
}

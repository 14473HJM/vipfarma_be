package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.UserEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.UserRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
public class UserServiceImplTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper modelMapper;

    @Before
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        modelMapper = Mockito.mock(ModelMapper.class);

        userService = new UserServiceImpl(userRepository, modelMapper);
    }

    @Test
    public void getUserById_OK() {
        User user = new User();
        user.setId(1L);
        user.setUserName("Test user");
        Mockito.when(userRepository.findAllById(Mockito.anyIterable())).thenReturn(Arrays.asList(new UserEntity()));
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(user);

        User response = userService.getById(1L);
        Assertions.assertEquals(response.getId(), 1L);
        Assertions.assertEquals(response.getUserName(), "Test user");
    }

    @Test(expected = EntityNotFoundException.class)
    public void getUserById_NotFound() {
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        userService.getById(1L);
    }
}

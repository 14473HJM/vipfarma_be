package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController extends AbstractController {

    private final UserService userService;

    @PostMapping("/user/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        User userLogged = userService.login(userName, password);

        return ResponseEntity.ok(userLogged);
    }

    @PostMapping("/user")
    public ResponseEntity<User> create(@RequestBody User user) {
        user = userService.createUser(user);
        return ResponseEntity.created(null).body(user);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> create(@RequestParam Long userId) {
        return null;
    }
}

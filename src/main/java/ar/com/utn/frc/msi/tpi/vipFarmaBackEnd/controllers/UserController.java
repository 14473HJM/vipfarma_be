package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Rack;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class UserController {

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
        user = userService.create(user);
        return ResponseEntity.created(null).body(user);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }
}

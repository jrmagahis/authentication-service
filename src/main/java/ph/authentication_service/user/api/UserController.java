package ph.authentication_service.user.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ph.authentication_service.user.model.User;
import ph.authentication_service.user.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody User user) throws Exception {
        userService.createUser(user);
        return ResponseEntity.ok("New User Created!");
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("connected");
    }
}

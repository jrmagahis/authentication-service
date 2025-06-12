package ph.authentication_service.authentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ph.authentication_service.authentication.model.LoginRequest;
import ph.authentication_service.user.model.User;
import ph.authentication_service.user.service.UserService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

//    private final UserService userService;


    @PostMapping("login")
    public String login(@RequestBody LoginRequest loginRequest) {
//        Optional<User> user = userService.findUser(loginRequest.getUsername());
        return "success!";

    }

    @PostMapping("register")
    public String register(@RequestBody User user) {
        return null;
    }


}

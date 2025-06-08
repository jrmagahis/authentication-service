package ph.authentication_service.authentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ph.authentication_service.authentication.model.LoginRequest;
import ph.authentication_service.user.model.User;
import ph.authentication_service.user.service.UserService;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("login")
    private String login(@RequestBody LoginRequest loginRequest) {




        return "success!";

    }

    @PostMapping("/register")
    private String register(@RequestBody User user) {
        return null;
    }


}

package ph.authentication_service.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ph.authentication_service.user.model.User;

@RestController
public class UserController {


    @PostMapping("login")
    private String login() {

        return "success!";

    }

    @PostMapping("/register")
    private String register(@RequestBody User user) {
        return null;
    }


}

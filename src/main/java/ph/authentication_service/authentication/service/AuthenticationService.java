package ph.authentication_service.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.authentication_service.authentication.model.LoginRequest;
import ph.authentication_service.security.PasswordsUtil;
import ph.authentication_service.user.model.User;
import ph.authentication_service.user.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final PasswordsUtil passwordUtil;

    public boolean login(LoginRequest loginRequest) throws Exception {

        Optional<User> userFound = userService.findUser(loginRequest.getUserName());
        User user = userFound.orElseThrow(()-> new Exception("User not found"));

        if (!user.isActive()) {
            throw new Exception("User is not active");
        }

        if (!passwordUtil.isPasswordMatch(user.getPassword(), loginRequest.getPassword())) {
            throw new Exception("Username or Password is incorrect");
        }

        return true;
    }

}

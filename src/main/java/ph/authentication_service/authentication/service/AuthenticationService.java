package ph.authentication_service.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ph.authentication_service.authentication.model.LoginRequest;
import ph.authentication_service.user.model.User;
import ph.authentication_service.user.service.UserService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public boolean login(LoginRequest loginRequest) throws Exception {

        Optional<User> userFound = userService.findUser(loginRequest.getUserName());
        User user = userFound.orElseThrow(()-> new Exception("User not found"));

        if (!user.isActive()) {
            throw new Exception("User is not active");
        }

        if (!passwordEncoder.matches(user.getPassword(), loginRequest.getPassword())) {
            throw new Exception("Username or Password is incorrect");
        }

        return true;
    }

}

package ph.authentication_service.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ph.authentication_service.authentication.model.LoginRequest;
import ph.authentication_service.user.model.User;
import ph.authentication_service.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public String userRegistration(User user) {

//        if (userExists()) {

        return "heh";
    }

    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }



}

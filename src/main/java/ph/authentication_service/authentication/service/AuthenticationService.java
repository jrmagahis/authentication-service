package ph.authentication_service.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ph.authentication_service.authentication.model.LoginRequest;
import ph.authentication_service.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void processLogin(LoginRequest loginRequest) { // should change return to a worthy response object
        // validate username existence first
        String username = loginRequest.getUsername();

        if (userRepository.existsByUsername(username)) {
            // continue with password validation
            String hashedPassword = passwordEncoder.encode(loginRequest.getPassword());
            if (isPasswordMatching(username, hashedPassword)) {
                // ok
            } else {
                // handle
            }

        } else {
        }
    }

    private boolean isPasswordMatching(String username, String hashedPassword) {
        String passwordFromUser = userRepository.findByUsername(username).getPassword();
        return passwordEncoder.matches(passwordFromUser, hashedPassword);

    }

}

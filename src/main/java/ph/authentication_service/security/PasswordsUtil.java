package ph.authentication_service.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordsUtil {

    PasswordEncoder passwordEncoder;

    public String passwordHashGenerator(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public boolean isPasswordMatch(String rawPassword, String storedHash) {
        return passwordEncoder.matches(rawPassword, storedHash);
    }

}

package ph.authentication_service.user.service;


import org.springframework.stereotype.Service;
import ph.authentication_service.user.model.User;
import ph.authentication_service.user.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public String userRegistration(User user) {

//        if (userExists()) {

        return "heh";
    }


    private boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }


}

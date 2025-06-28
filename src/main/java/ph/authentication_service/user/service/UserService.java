package ph.authentication_service.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ph.authentication_service.user.model.User;
import ph.authentication_service.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUser(String userName) {
        return Optional.ofNullable(userRepository.findByUserName(userName));
    }

    @Transactional
    public void createUser(User registrationRequest) throws Exception {

        Optional<User> userFound = findUser(registrationRequest.getUserName());
        if (userFound.isPresent()) {
            throw new Exception("User already exists!");
        }

        registrationRequest.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        registrationRequest.setActive(true);
        userRepository.save(registrationRequest);

    }

    public User updateUser(User userUpdateRequest) throws Exception {
        Optional<User> userFound = findUser(userUpdateRequest.getUserName());
        User user = userFound.orElseThrow(()-> new Exception("User not found"));

        user.setPassword(passwordEncoder.encode(userUpdateRequest.getPassword()));
        userRepository.save(user);

        return userRepository.findById(user.getId());

    }

    public void deleteUser(long id) throws Exception {
        Optional<User> userFound = Optional.ofNullable(userRepository.findById(id));
        User user = userFound.orElseThrow(()-> new Exception("User not found"));

        userRepository.deleteById(id);

    }


}

package ph.authentication_service.user.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import ph.authentication_service.user.model.User;
import ph.authentication_service.user.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setup()  {
        testUser = new User(1L, "test_user", "password123", true);
    }

    @Test
    void shouldReturnUser_When_UserExists() {
        when(userRepository.findByUserName("test_user")).thenReturn(testUser);

        Optional<User> testUserOpt = userService.findUser("test_user");

        Assertions.assertTrue(testUserOpt.isPresent());
        Assertions.assertEquals("test_user", testUserOpt.get().getUserName());

    }

    @Test
    void shouldReturnNull_When_UserDoesNotExist() {
        when(userRepository.findByUserName("test_user")).thenReturn(null);

        Optional<User> testUserOpt = userService.findUser("test_user");
        Assertions.assertFalse(testUserOpt.isPresent());
    }

    @Test
    void shouldNotCreateUser_When_UserExists() {
        when(userRepository.findByUserName("test_user")).thenReturn(testUser);

        Optional<User> testUserOpt = userService.findUser("test_user");

        User inputUser = new User();
        inputUser.setUserName("test_user");

        Exception exception = assertThrows(Exception.class, () -> {
            userService.createUser(inputUser);
        });

        Assertions.assertEquals("User already exists!", exception.getMessage());
        verify(userRepository, never()).save(any(User.class));

    }

    @Test
    void shouldCreateUser_When_UserDoesNotExist() {
        when(userRepository.findByUserName("test_user")).thenReturn(null);
        Optional<User> testUserOpt = userService.findUser("test_user");
        Assertions.assertDoesNotThrow(() -> userService.createUser(testUser));
        verify(userRepository).save(any(User.class));

    }


}

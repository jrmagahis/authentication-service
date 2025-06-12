package ph.authentication_service.user.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ph.authentication_service.user.model.User;
import ph.authentication_service.user.repository.UserRepository;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

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




}

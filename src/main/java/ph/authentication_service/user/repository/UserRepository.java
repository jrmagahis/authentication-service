package ph.authentication_service.user.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import ph.authentication_service.user.model.User;

public interface UserRepository extends JpaRepository<User, Id> {

    User findByUsername(String username);
    boolean existsByUsername(String username);

}

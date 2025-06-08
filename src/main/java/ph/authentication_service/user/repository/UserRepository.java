package ph.authentication_service.user.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.authentication_service.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Id> {

    User findByUsername(String username);
    boolean existsByUsername(String username);

}

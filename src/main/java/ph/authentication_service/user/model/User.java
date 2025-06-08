package ph.authentication_service.user.model;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class User {

    @Id
    private long id;

    private String username;

    private String password;


}

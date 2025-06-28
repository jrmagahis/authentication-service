package ph.authentication_service.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "\"USER\"")
public class User {

    @Id
    private long id;

    private String userName;

    private String password;

    private boolean isActive;

}

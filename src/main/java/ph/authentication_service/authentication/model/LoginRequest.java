package ph.authentication_service.authentication.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginRequest {

    private String userName;

    private String password;

}

package s_sercurity.session.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {
    private String userName;
    private String password;
    private String role;
}

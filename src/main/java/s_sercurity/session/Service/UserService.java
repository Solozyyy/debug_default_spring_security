package s_sercurity.session.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import s_sercurity.session.DTO.LoginRequestDTO;
import s_sercurity.session.DTO.RegisterRequestDTO;
import s_sercurity.session.Domain.User;
import s_sercurity.session.Repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public boolean RegisterAuth(RegisterRequestDTO registerRequestDTO) {

        User user = new User();
        user.setUserName(registerRequestDTO.getUserName());
        String hashedPassword = passwordEncoder.encode(registerRequestDTO.getPassword());
        user.setPassword(hashedPassword);
        user.setRole(registerRequestDTO.getRole());
        userRepository.save(user);
        return true;
    }

    public boolean LoginAuth(LoginRequestDTO loginRequestDTO) {

        return true;
    }

}

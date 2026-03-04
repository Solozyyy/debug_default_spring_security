package s_sercurity.session.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import s_sercurity.session.DTO.LoginRequestDTO;
import s_sercurity.session.DTO.RegisterRequestDTO;
import s_sercurity.session.Service.UserService;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody RegisterRequestDTO registerRequestDTO,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldErrors());
        }

        boolean isAuth = userService.RegisterAuth(registerRequestDTO);

        if (isAuth) {
            return ResponseEntity.ok("Register successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Register failed");
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody LoginRequestDTO loginRequestDTO,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldErrors());
        }

        boolean isAuth = userService.LoginAuth(loginRequestDTO);

        if (isAuth) {
            return ResponseEntity.ok("Login successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }

    }
}

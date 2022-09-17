package be.dog.d.steven.toolboxadapter.users;

import be.dog.d.steven.toolboxdomain.security.service.AuthService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;

    @GetMapping("auth")
    public Map<String, Object> token() {
        return authService.token();
    }
}

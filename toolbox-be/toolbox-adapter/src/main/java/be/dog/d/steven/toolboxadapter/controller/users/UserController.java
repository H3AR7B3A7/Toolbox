package be.dog.d.steven.toolboxadapter.controller.users;

import be.dog.d.steven.toolboxdomain.security.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "User", description = "Information on the authenticated user")
public class UserController {

    private final AuthService authService;

    @GetMapping("auth")
    @Operation(summary = "Get information on the authenticated user.")
    public Map<String, Object> token() {
        return authService.token();
    }
}

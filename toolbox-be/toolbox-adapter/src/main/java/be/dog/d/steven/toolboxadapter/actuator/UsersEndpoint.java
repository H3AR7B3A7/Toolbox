package be.dog.d.steven.toolboxadapter.actuator;

import be.dog.d.steven.toolboxdomain.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Service;

@Service
@Endpoint(id = "users")
@RequiredArgsConstructor
public class UsersEndpoint {

    private final UserService userService;

    @ReadOperation
    public String getUserCount() {
        return userService.userCountMetric();
    }
}

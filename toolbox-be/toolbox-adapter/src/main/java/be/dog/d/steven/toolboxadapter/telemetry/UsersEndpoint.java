package be.dog.d.steven.toolboxadapter.telemetry;

import be.dog.d.steven.toolboxdomain.security.service.UserService;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Endpoint(id = "users")
@RequiredArgsConstructor
public class UsersEndpoint {

    private final UserService userService;

    @ReadOperation
    public String getUserCount() {
        return new JSONObject(Map.of("users", userService.count())).toJSONString();
    }
}
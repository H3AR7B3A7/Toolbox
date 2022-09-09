package be.dog.d.steven.toolplatform.telemetry;

import be.dog.d.steven.toolplatform.security.repository.UserRepository;
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
    private final UserRepository userRepository;
    
    @ReadOperation
    public String getUserCount() {
        return new JSONObject(Map.of("users", userRepository.count())).toJSONString();
    }
}
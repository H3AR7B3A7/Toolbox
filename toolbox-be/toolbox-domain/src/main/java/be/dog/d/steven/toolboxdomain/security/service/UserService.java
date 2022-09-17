package be.dog.d.steven.toolboxdomain.security.service;

import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import be.dog.d.steven.toolboxdatabase.repository.UserRepository;
import be.dog.d.steven.toolboxdomain.security.command.UserRegistrationCommand;
import com.nimbusds.jose.shaded.json.JSONObject;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void registerNewUser(UserRegistrationCommand userRegistrationCommand) {
        ToolboxUser user = userRepository.findByUserName(userRegistrationCommand.getUsername());
        if (user == null) {
            ToolboxUser savedUser = userRepository.save(userRegistrationCommand.toToolboxUser());
            log.info("New user registered: " + savedUser.getUserName());
        }
    }

    public String userCountMetric() {
        return new JSONObject(Map.of("users", userRepository.count())).toJSONString();
    }
}

package be.dog.d.steven.toolplatform.security.service;

import be.dog.d.steven.toolplatform.security.entity.ToolPlatformUser;
import be.dog.d.steven.toolplatform.security.model.UserRegistrationRequest;
import be.dog.d.steven.toolplatform.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRegistrationService {
    private final UserRepository userRepository;

    public void registerNewUser(UserRegistrationRequest userRegistrationRequest) {
        ToolPlatformUser user = userRepository.findByUsername(userRegistrationRequest.getUsername());
        if (user == null) {
            ToolPlatformUser savedUser = userRepository.save(new ToolPlatformUser(userRegistrationRequest));
            log.info("New user registered:" + savedUser.getUsername());
        } else {
            log.info("User logged in:" + userRegistrationRequest.getUsername());
        }
    }
}
package be.dog.d.steven.toolplatform.security.service;

import be.dog.d.steven.toolplatform.security.entity.ToolboxUser;
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
        ToolboxUser user = userRepository.findByUserName(userRegistrationRequest.getUsername());
        if (user == null) {
            ToolboxUser savedUser = userRepository.save(new ToolboxUser(userRegistrationRequest));
            log.info("New user registered: " + savedUser.getUserName());
        }
    }
}
package be.dog.d.steven.toolboxdomain.security.service;

import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import be.dog.d.steven.toolboxdomain.security.model.UserRegistrationRequest;
import be.dog.d.steven.toolboxdomain.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void registerNewUser(UserRegistrationRequest userRegistrationRequest) {
        ToolboxUser user = userRepository.findByUserName(userRegistrationRequest.getUsername());
        if (user == null) {
            ToolboxUser savedUser = userRepository.save(userRegistrationRequest.toToolboxUser());
            log.info("New user registered: " + savedUser.getUserName());
        }
    }

    public long count() {
        return this.userRepository.count();
    }
}
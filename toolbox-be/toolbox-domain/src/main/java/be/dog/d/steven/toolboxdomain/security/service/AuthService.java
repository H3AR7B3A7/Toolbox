package be.dog.d.steven.toolboxdomain.security.service;

import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import be.dog.d.steven.toolboxdatabase.repository.UserRepository;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public Map<String, Object> token() {
        return getOAuthToken().getPrincipal().getAttributes();
    }

    public ToolboxUser currentUser() {
        String toolboxUserId = (String) token().get("sub");
        return userRepository.findByToolboxUserId(toolboxUserId);
    }

    private OAuth2AuthenticationToken getOAuthToken() {
        return (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    }
}

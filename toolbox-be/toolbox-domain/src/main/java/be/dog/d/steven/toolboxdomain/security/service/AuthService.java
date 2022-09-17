package be.dog.d.steven.toolboxdomain.security.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthService {

    public Map<String, Object> token() {
        return getOAuthToken().getPrincipal().getAttributes();
    }

    private OAuth2AuthenticationToken getOAuthToken() {
        return (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    }
}
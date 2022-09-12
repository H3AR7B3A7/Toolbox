package be.dog.d.steven.toolplatform.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("auth")
    public Map<String, Object> token(){
        return getOAuthToken().getPrincipal().getAttributes();
    }

    private OAuth2AuthenticationToken getOAuthToken() {
        return (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    }
}
package be.dog.d.steven.toolplatform.security.configuration;

import be.dog.d.steven.toolplatform.security.model.UserRegistrationRequest;
import be.dog.d.steven.toolplatform.security.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    private final UserRegistrationService userRegistrationService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        var oidcUser = (OidcUser) authentication.getPrincipal();

        var registrationRequest = UserRegistrationRequest.builder()
                .username(oidcUser.getSubject())
                .email(oidcUser.getEmail())
                .firstname(oidcUser.getGivenName())
                .lastname(oidcUser.getFamilyName())
                .build();
        
        this.userRegistrationService.registerNewUser(registrationRequest);
        log.info("User logged in: " + authentication.getName());
        response.sendRedirect("http://localhost:4200/toolbox-ui");
    }
}
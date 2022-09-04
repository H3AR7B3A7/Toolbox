package be.dog.d.steven.toolplatform.security.configuration;

import be.dog.d.steven.toolplatform.security.model.UserRegistrationRequest;
import be.dog.d.steven.toolplatform.security.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    private final UserRegistrationService userRegistrationService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        UserRegistrationRequest registrationRequest = new UserRegistrationRequest();
        OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
        registrationRequest.setUsername(oidcUser.getSubject());
        registrationRequest.setEmail(oidcUser.getEmail());
        registrationRequest.setFirstname(oidcUser.getGivenName());
        registrationRequest.setLastname(oidcUser.getFamilyName());
        this.userRegistrationService.registerNewUser(registrationRequest);
        response.sendRedirect("/");
    }
}
package be.dog.d.steven.toolplatform.security.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "${spring.application.name}",
                description = "${spring.application.description}",
                version = "${spring.application.version}"),
        servers = {
                @Server(url = "${server.servlet.context-path}")
        })
@SecurityScheme(
        name = "Google Authentication",
        type = SecuritySchemeType.OAUTH2,
        flows = @OAuthFlows(
                authorizationCode = @OAuthFlow(
                        authorizationUrl = "${server.servlet.context-path}/oauth2/authorization/google")))
public class OpenApiConfig {
}
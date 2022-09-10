package be.dog.d.steven.toolplatform.security.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegistrationRequest {
    
    private String firstname;
    private String lastname;
    private String username;
    private String email;
}
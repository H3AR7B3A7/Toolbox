package be.dog.d.steven.toolplatform.security.model;

import lombok.Data;

@Data
public class UserRegistrationRequest {

    private String firstname;
    private String lastname;
    private String username;
    private String email;
}
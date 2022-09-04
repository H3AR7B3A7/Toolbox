package be.dog.d.steven.toolplatform.security.entity;

import be.dog.d.steven.toolplatform.security.model.UserRegistrationRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOOL_PLATFORM_USER")
@NoArgsConstructor
@Getter
public class ToolPlatformUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)

    @Setter
    private String username;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String email;

    public ToolPlatformUser(UserRegistrationRequest userRegistration) {
        this.username = userRegistration.getUsername();
        this.email = userRegistration.getEmail();
        this.firstName = userRegistration.getFirstname();
        this.lastName = userRegistration.getLastname();
    }
}
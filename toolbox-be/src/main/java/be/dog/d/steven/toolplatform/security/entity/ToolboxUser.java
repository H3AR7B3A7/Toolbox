package be.dog.d.steven.toolplatform.security.entity;

import be.dog.d.steven.toolplatform.security.model.UserRegistrationRequest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TOOLBOX_USER")
@NoArgsConstructor
@Getter
public class ToolboxUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Setter
    private String userName;

    @Setter
    private String firstName;

    @Setter
    private String lastName;

    @Setter
    private String email;

    public ToolboxUser(UserRegistrationRequest userRegistration) {
        this.userName = userRegistration.getUsername();
        this.email = userRegistration.getEmail();
        this.firstName = userRegistration.getFirstname();
        this.lastName = userRegistration.getLastname();
    }
}

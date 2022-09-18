package be.dog.d.steven.toolboxdatabase.model;

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
    private String toolboxUserId;

    @Setter
    private String firstName;

    @Setter
    private String lastName;

    @Setter
    private String email;

    public ToolboxUser(String toolboxUserId, String firstName, String lastName, String email) {
        this.toolboxUserId = toolboxUserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}

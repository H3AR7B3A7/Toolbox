package be.dog.d.steven.toolboxdomain.security.command;

import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegistrationCommand {

    private String firstname;
    private String lastname;
    private String username;
    private String email;

    public ToolboxUser toToolboxUser() {
        return new ToolboxUser(username, firstname, lastname, email);
    }
}

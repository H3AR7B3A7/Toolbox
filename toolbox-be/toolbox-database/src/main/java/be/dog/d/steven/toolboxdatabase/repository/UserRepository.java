package be.dog.d.steven.toolboxdatabase.repository;

import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    ToolboxUser findByUserName(String username);

    long count();

    ToolboxUser save(ToolboxUser toolboxUser);
}

package be.dog.d.steven.toolboxdatabase.repository;

import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;

public interface UserRepository {
    ToolboxUser findByToolboxUserId(String username);

    long count();

    ToolboxUser save(ToolboxUser toolboxUser);
}

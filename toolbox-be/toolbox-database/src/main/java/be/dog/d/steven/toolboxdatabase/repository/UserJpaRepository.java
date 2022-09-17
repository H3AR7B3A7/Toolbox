package be.dog.d.steven.toolboxdatabase.repository;

import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends UserRepository, JpaRepository<ToolboxUser, Long> {
    ToolboxUser findByToolboxUserId(String toolboxUserId);
}

package be.dog.d.steven.toolplatform.security.repository;

import be.dog.d.steven.toolplatform.security.entity.ToolboxUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ToolboxUser, Long> {
    ToolboxUser findByUserName(String username);
}

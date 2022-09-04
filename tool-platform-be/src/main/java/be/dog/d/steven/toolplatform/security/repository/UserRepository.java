package be.dog.d.steven.toolplatform.security.repository;

import be.dog.d.steven.toolplatform.security.entity.ToolPlatformUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ToolPlatformUser, Long> {

    ToolPlatformUser findByUsername(String username);
}
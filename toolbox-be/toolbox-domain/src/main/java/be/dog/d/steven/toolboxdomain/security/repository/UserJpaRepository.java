package be.dog.d.steven.toolboxdomain.security.repository;

import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends UserRepository, JpaRepository<ToolboxUser, Long> {
    ToolboxUser findByUserName(String username);
}
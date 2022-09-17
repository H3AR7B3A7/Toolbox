package be.dog.d.steven.toolboxdatabase.repository;

import be.dog.d.steven.toolboxdatabase.model.TodoBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoBoardJpaRepository extends TodoBoardRepository, JpaRepository<TodoBoard, Long> {}

package be.dog.d.steven.toolboxdatabase.repository;

import be.dog.d.steven.toolboxdatabase.model.TodoBoard;
import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import java.util.List;
import java.util.Optional;

public interface TodoBoardRepository {
    TodoBoard save(TodoBoard todoBoard);

    List<TodoBoard> findTodoBoardsByToolboxUser(ToolboxUser toolboxUser);

    Optional<TodoBoard> findByTodoBoardIdAndToolboxUser(String todoBoardId, ToolboxUser toolboxUser);

    void delete(TodoBoard todoBoard);
}

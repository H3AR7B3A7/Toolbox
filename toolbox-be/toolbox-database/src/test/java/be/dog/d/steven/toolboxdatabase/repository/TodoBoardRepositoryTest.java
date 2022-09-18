package be.dog.d.steven.toolboxdatabase.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import be.dog.d.steven.toolboxdatabase.model.TodoBoard;
import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class TodoBoardRepositoryTest {

    @Autowired
    private TodoBoardRepository todoBoardRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Nested
    @DisplayName("Given a repository")
    class Given {

        @Nested
        @DisplayName("When it contains a todo board")
        class When {

            @Test
            @DisplayName("Then we can find it by todoBoardId and toolBoxUser")
            void canFindTodoBoard() {
                ToolboxUser toolboxUser = new ToolboxUser();
                TodoBoard newTodoBoard = new TodoBoard();
                newTodoBoard.setTitle("Title");
                newTodoBoard.setToolboxUser(toolboxUser);
                TodoBoard savedTodoBoard = entityManager.persistFlushFind(newTodoBoard);

                Optional<TodoBoard> todoBoard =
                        todoBoardRepository.findByTodoBoardIdAndToolboxUser(newTodoBoard.getTodoBoardId(), toolboxUser);

                assertThat(todoBoard.get().getTitle()).isEqualTo(savedTodoBoard.getTitle());
            }
        }
    }
}

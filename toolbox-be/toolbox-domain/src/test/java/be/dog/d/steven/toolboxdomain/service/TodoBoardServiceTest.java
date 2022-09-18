package be.dog.d.steven.toolboxdomain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import be.dog.d.steven.toolboxdatabase.model.Todo;
import be.dog.d.steven.toolboxdatabase.model.TodoBoard;
import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import be.dog.d.steven.toolboxdatabase.model.exception.TodoBoardNotFoundException;
import be.dog.d.steven.toolboxdatabase.repository.TodoBoardRepository;
import be.dog.d.steven.toolboxdomain.security.service.AuthService;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TodoBoardServiceTest {

    @InjectMocks
    private TodoBoardService todoBoardService;

    @Mock
    private AuthService authService;

    @Mock
    private TodoBoardRepository todoBoardRepository;

    @Captor
    private ArgumentCaptor<TodoBoard> todoBoardArgumentCaptor;

    @Nested
    @DisplayName("Given an authenticated user")
    class Given {

        @Nested
        @DisplayName("When there are todo boards for that user")
        class WhenGet {

            @Test
            @DisplayName("Then we can get all TodoBoards for that user")
            void findAllTodoBoardsTest() {
                TodoBoard todoBoard = new TodoBoard();
                when(todoBoardRepository.findTodoBoardsByToolboxUser(any())).thenReturn(List.of(todoBoard));
                when(authService.currentUser()).thenReturn(new ToolboxUser());

                List<TodoBoard> todoBoards = todoBoardService.getAllTodoBoards();

                assertThat(todoBoards.get(0).getTodoBoardId()).isEqualTo(todoBoard.getTodoBoardId());
                assertThat(todoBoards.size()).isEqualTo(1);
            }
        }

        @Nested
        @DisplayName("When the user creates a todo board")
        class WhenCreate {

            @Test
            @DisplayName("Then the todo board is saved")
            void findAllTodoBoardsTest() {
                TodoBoard todoBoard = new TodoBoard();
                todoBoard.setTitle("Title");

                todoBoardService.createTodoBoard((todoBoard));

                verify(todoBoardRepository).save(todoBoardArgumentCaptor.capture());
                TodoBoard captured = todoBoardArgumentCaptor.getValue();
                assertThat(captured.getTitle()).isEqualTo("Title");
            }
        }

        @Nested
        @DisplayName("When the user updates a todo board")
        class WhenUpdate {

            @Test
            @DisplayName("Then the updated todo board is saved")
            void findAllTodoBoardsTest() {
                TodoBoard todoBoard = new TodoBoard();
                todoBoard.setTitle("Title");
                TodoBoard update = new TodoBoard();
                update.setTitle("NewTitle");

                when(todoBoardRepository.findByTodoBoardIdAndToolboxUser(any(), any()))
                        .thenReturn(Optional.of(todoBoard));
                todoBoardService.updateTodoBoard(todoBoard.getTodoBoardId(), update);

                verify(todoBoardRepository).save(todoBoardArgumentCaptor.capture());
                TodoBoard captured = todoBoardArgumentCaptor.getValue();
                assertThat(captured.getTitle()).isEqualTo("NewTitle");
            }
        }

        @Nested
        @DisplayName("When the user deletes a todo board")
        class WhenDelete {

            @Test
            @DisplayName("Then the todo board is deleted")
            void findAllTodoBoardsTest() {
                TodoBoard todoBoard = new TodoBoard();
                todoBoard.setTitle("Title");
                when(todoBoardRepository.findByTodoBoardIdAndToolboxUser(any(), any()))
                        .thenReturn(Optional.of(todoBoard));

                todoBoardService.deleteTodoBoard(todoBoard.getTodoBoardId());

                verify(todoBoardRepository).delete(todoBoardArgumentCaptor.capture());
                TodoBoard captured = todoBoardArgumentCaptor.getValue();
                assertThat(captured.getTitle()).isEqualTo("Title");
            }
        }

        @Nested
        @DisplayName("When a todo board does not exist")
        class WhenNotFound {

            @Test
            @DisplayName("Then creating a Todo throws a CreateTodoException")
            void createTodoWhenTodoBoardDoesNotExistTest() {
                Runnable createTodoForFaultyTodoBoardId = () -> todoBoardService.createTodo("", new Todo());

                assertThrows(TodoBoardNotFoundException.class, createTodoForFaultyTodoBoardId::run);
            }

            @Test
            @DisplayName("Then Deleting a Todo throws a DeleteTodoException")
            void deleteTodoWhenTodoBoardDoesNotExistTest() {
                Runnable deleteTodoForFaultyTodoBoardId = () -> todoBoardService.deleteTodo("", "");

                assertThrows(TodoBoardNotFoundException.class, deleteTodoForFaultyTodoBoardId::run);
            }
        }
    }
}

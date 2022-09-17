package be.dog.d.steven.toolboxdomain.service;

import be.dog.d.steven.toolboxdatabase.model.Todo;
import be.dog.d.steven.toolboxdatabase.model.TodoBoard;
import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import be.dog.d.steven.toolboxdatabase.model.exception.TodoBoardNotFoundException;
import be.dog.d.steven.toolboxdatabase.repository.TodoBoardRepository;
import be.dog.d.steven.toolboxdomain.security.service.AuthService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoBoardService {

    private final TodoBoardRepository todoBoardRepository;
    private final AuthService authService;

    public List<TodoBoard> getAllTodoBoards() {
        return todoBoardRepository.findTodoBoardsByToolboxUser(authService.currentUser());
    }

    public TodoBoard createTodoBoard(TodoBoard todoBoard) {
        return todoBoardRepository.save(todoBoard);
    }

    public void deleteTodoBoard(String todoBoardId) {
        ToolboxUser currentUser = authService.currentUser();
        TodoBoard todoBoard = todoBoardRepository
                .findByTodoBoardIdAndToolboxUser(todoBoardId, currentUser)
                .orElseThrow(() -> new TodoBoardNotFoundException(todoBoardId));
        todoBoardRepository.delete(todoBoard);
    }

    public Todo createTodo(String todoBoardId, Todo todo) {
        ToolboxUser currentUser = authService.currentUser();
        TodoBoard todoBoard = todoBoardRepository
                .findByTodoBoardIdAndToolboxUser(todoBoardId, currentUser)
                .orElseThrow(() -> new TodoBoardNotFoundException(todoBoardId));
        todoBoard.addTodo(todo);
        todoBoardRepository.save(todoBoard);
        return todo;
    }

    public void deleteTodo(String todoBoardId, String todoId) {
        ToolboxUser currentUser = authService.currentUser();
        TodoBoard todoBoard = todoBoardRepository
                .findByTodoBoardIdAndToolboxUser(todoBoardId, currentUser)
                .orElseThrow(() -> new TodoBoardNotFoundException(todoBoardId));
        todoBoard.removeTodo(todoId);
        todoBoardRepository.save(todoBoard);
    }
}

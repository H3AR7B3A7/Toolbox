package be.dog.d.steven.toolboxdomain.service;

import be.dog.d.steven.toolboxdatabase.model.Todo;
import be.dog.d.steven.toolboxdatabase.model.TodoBoard;
import be.dog.d.steven.toolboxdatabase.model.ToolboxUser;
import be.dog.d.steven.toolboxdatabase.model.exception.TodoBoardNotFoundException;
import be.dog.d.steven.toolboxdatabase.repository.TodoBoardRepository;
import be.dog.d.steven.toolboxdomain.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoBoardService {

    private final TodoBoardRepository todoBoardRepository;
    private final AuthService authService;

    public List<TodoBoard> getAllTodoBoards() {
        return todoBoardRepository.findTodoBoardsByToolboxUser(authService.currentUser());
    }

    public TodoBoard createTodoBoard(TodoBoard todoBoard) {
        todoBoard.setToolboxUser(authService.currentUser());
        return todoBoardRepository.save(todoBoard);
    }

    public TodoBoard updateTodoBoard(String todoBoardId, TodoBoard todoBoard) {
        ToolboxUser currentUser = authService.currentUser();
        TodoBoard todoBoardToUpdate = todoBoardRepository
                .findByTodoBoardIdAndToolboxUser(todoBoardId, currentUser)
                .orElseThrow(() -> new TodoBoardNotFoundException(todoBoardId));
        todoBoardToUpdate.setTitle(todoBoard.getTitle());
        return todoBoardRepository.save(todoBoardToUpdate);
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
        todo.setCompleted(false);
        todoBoard.addTodo(todo);
        todoBoardRepository.save(todoBoard);
        return todo;
    }

    public Todo updateTodo(String todoBoardId, String todoId, Todo todo) {
        ToolboxUser currentUser = authService.currentUser();
        TodoBoard todoBoard = todoBoardRepository
                .findByTodoBoardIdAndToolboxUser(todoBoardId, currentUser)
                .orElseThrow(() -> new TodoBoardNotFoundException(todoBoardId));
        Todo result = todoBoard.updateTodo(todoId, todo);
        todoBoardRepository.save(todoBoard);
        return result;
    }

    public void deleteTodo(String todoBoardId, String todoId) {
        ToolboxUser currentUser = authService.currentUser();
        TodoBoard todoBoard = todoBoardRepository
                .findByTodoBoardIdAndToolboxUser(todoBoardId, currentUser)
                .orElseThrow(() -> new TodoBoardNotFoundException(todoBoardId));
        todoBoard.removeTodo(todoId);
        todoBoardRepository.save(todoBoard);
    }

    public void patchCompleted(String todoBoardId, String todoId) {
        ToolboxUser currentUser = authService.currentUser();
        TodoBoard todoBoard = todoBoardRepository
                .findByTodoBoardIdAndToolboxUser(todoBoardId, currentUser)
                .orElseThrow(() -> new TodoBoardNotFoundException(todoBoardId));
        todoBoard.patchCompleted(todoId);
        todoBoardRepository.save(todoBoard);
    }
}
package be.dog.d.steven.toolboxadapter.controller.todoboards;

import be.dog.d.steven.toolboxadapter.controller.todoboards.command.CreateTodoBoardCommand;
import be.dog.d.steven.toolboxadapter.controller.todoboards.command.CreateTodoCommand;
import be.dog.d.steven.toolboxadapter.controller.todoboards.dto.TodoBoardDto;
import be.dog.d.steven.toolboxadapter.controller.todoboards.dto.TodoDto;
import be.dog.d.steven.toolboxadapter.mapper.TodoBoardMapper;
import be.dog.d.steven.toolboxdatabase.model.Todo;
import be.dog.d.steven.toolboxdatabase.model.TodoBoard;
import be.dog.d.steven.toolboxdomain.security.service.AuthService;
import be.dog.d.steven.toolboxdomain.service.TodoBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/todoboards")
@RequiredArgsConstructor
public class TodoBoardController {

    private final TodoBoardService todoBoardService;
    private final AuthService authService;
    private final TodoBoardMapper todoBoardMapper;

    @GetMapping
    public List<TodoBoardDto> getTodoBoardsForUser() {
        return todoBoardService.getAllTodoBoards().stream()
                .map(todoBoardMapper::mapTodoBoard)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoBoardDto createTodoBoard(@RequestBody CreateTodoBoardCommand createTodoBoardCommand) {
        TodoBoard todoBoard = todoBoardMapper.mapTodoBoard(createTodoBoardCommand);
        todoBoard.setToolboxUser(authService.currentUser());
        return todoBoardMapper.mapTodoBoard(todoBoardService.createTodoBoard(todoBoard));
    }

    @DeleteMapping("/{todoBoardId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodoBoard(@PathVariable String todoBoardId) {
        todoBoardService.deleteTodoBoard(todoBoardId);
    }

    @PostMapping("/{todoBoardId}")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDto createTodo(@PathVariable String todoBoardId, @Valid @RequestBody CreateTodoCommand createTodoDto) {
        Todo todo = todoBoardMapper.mapTodo(createTodoDto);
        return todoBoardMapper.mapTodo(todoBoardService.createTodo(todoBoardId, todo));
    }

    @DeleteMapping("/{todoBoardId}/todos/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable String todoBoardId, @PathVariable String todoId) {
        todoBoardService.deleteTodo(todoBoardId, todoId);
    }
}
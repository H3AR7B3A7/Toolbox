package be.dog.d.steven.toolboxadapter.controller.todoboards;

import be.dog.d.steven.toolboxadapter.controller.todoboards.command.CreateTodoBoardCommand;
import be.dog.d.steven.toolboxadapter.controller.todoboards.command.CreateTodoCommand;
import be.dog.d.steven.toolboxadapter.controller.todoboards.dto.TodoBoardDto;
import be.dog.d.steven.toolboxadapter.controller.todoboards.dto.TodoDto;
import be.dog.d.steven.toolboxadapter.mapper.TodoBoardMapper;
import be.dog.d.steven.toolboxdatabase.model.Todo;
import be.dog.d.steven.toolboxdatabase.model.TodoBoard;
import be.dog.d.steven.toolboxdomain.service.TodoBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/todoboards")
@RequiredArgsConstructor
@Tag(name = "Todo Boards", description = "Manage todos and todo boards")
public class TodoBoardController {

    private final TodoBoardService todoBoardService;
    private final TodoBoardMapper todoBoardMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all todo boards for authenticated user.")
    public List<TodoBoardDto> getTodoBoardsForUser() {
        return todoBoardService.getAllTodoBoards().stream()
                .map(todoBoardMapper::mapTodoBoard)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a todo board for the authenticated user.")
    public TodoBoardDto createTodoBoard(@RequestBody CreateTodoBoardCommand createTodoBoardCommand) {
        TodoBoard todoBoard = todoBoardMapper.mapTodoBoard(createTodoBoardCommand);
        return todoBoardMapper.mapTodoBoard(todoBoardService.createTodoBoard(todoBoard));
    }

    @PutMapping("/{todoBoardId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a todo board for the authenticated user.")
    public TodoBoardDto updateTodoBoard(@PathVariable String todoBoardId, @RequestBody CreateTodoBoardCommand createTodoBoardCommand) {
        TodoBoard todoBoard = todoBoardMapper.mapTodoBoard(createTodoBoardCommand);
        return todoBoardMapper.mapTodoBoard(todoBoardService.updateTodoBoard(todoBoardId, todoBoard));
    }

    @DeleteMapping("/{todoBoardId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a todo board for the authenticated user.")
    public void deleteTodoBoard(@PathVariable String todoBoardId) {
        todoBoardService.deleteTodoBoard(todoBoardId);
    }

    @PostMapping("/{todoBoardId}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a todo to a todo board for the authenticated user.")
    public TodoDto createTodo(@PathVariable String todoBoardId, @Valid @RequestBody CreateTodoCommand createTodoDto) {
        Todo todo = todoBoardMapper.mapTodo(createTodoDto);
        return todoBoardMapper.mapTodo(todoBoardService.createTodo(todoBoardId, todo));
    }

    @PutMapping("/{todoBoardId}/todos/{todoId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a todo on a todo board for the authenticated user.")
    public TodoDto updateTodo(@PathVariable String todoBoardId, @PathVariable String todoId, @Valid @RequestBody CreateTodoCommand createTodoDto) {
        Todo todo = todoBoardMapper.mapTodo(createTodoDto);
        return todoBoardMapper.mapTodo(todoBoardService.updateTodo(todoBoardId, todoId, todo));
    }

    @DeleteMapping("/{todoBoardId}/todos/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove a todo from a todo board for the authenticated user.")
    public void deleteTodo(@PathVariable String todoBoardId, @PathVariable String todoId) {
        todoBoardService.deleteTodo(todoBoardId, todoId);
    }
    
    @PatchMapping("/{todoBoardId}/todos/{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Patch a todo on a todo board for the authenticated user.")
    public void patchCompleted(@PathVariable String todoBoardId, @PathVariable String todoId) {
        todoBoardService.patchCompleted(todoBoardId, todoId);
    }
}
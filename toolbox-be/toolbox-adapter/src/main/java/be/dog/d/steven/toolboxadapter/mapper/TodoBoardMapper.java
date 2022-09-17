package be.dog.d.steven.toolboxadapter.mapper;

import be.dog.d.steven.toolboxadapter.controller.todoboards.command.CreateTodoBoardCommand;
import be.dog.d.steven.toolboxadapter.controller.todoboards.command.CreateTodoCommand;
import be.dog.d.steven.toolboxadapter.controller.todoboards.dto.TodoBoardDto;
import be.dog.d.steven.toolboxadapter.controller.todoboards.dto.TodoDto;
import be.dog.d.steven.toolboxdatabase.model.Todo;
import be.dog.d.steven.toolboxdatabase.model.TodoBoard;
import org.springframework.stereotype.Service;

@Service
public class TodoBoardMapper {

    public TodoBoardDto mapTodoBoard(TodoBoard todoBoard) {
        TodoBoardDto todoBoardDto = new TodoBoardDto();
        todoBoardDto.setTodoBoardId(todoBoard.getTodoBoardId());
        todoBoardDto.setTitle(todoBoard.getTitle());
        todoBoardDto.setTodos(
                todoBoard.getCopyOfTodos().stream().map(this::mapTodo).toList());
        return todoBoardDto;
    }

    public TodoDto mapTodo(Todo todo) {
        TodoDto todoDto = new TodoDto();
        todoDto.setTodoId(todo.getTodoId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setBody(todo.getBody());
        todoDto.setCompleted(todo.isCompleted());
        return todoDto;
    }

    public TodoBoard mapTodoBoard(CreateTodoBoardCommand createTodoBoardCommand) {
        TodoBoard todoBoard = new TodoBoard();
        todoBoard.setTitle(createTodoBoardCommand.getTitle());
        return todoBoard;
    }

    public Todo mapTodo(CreateTodoCommand createTodoCommand) {
        Todo todo = new Todo();
        todo.setTitle(createTodoCommand.getTitle());
        todo.setBody(createTodoCommand.getBody());
        return todo;
    }
}
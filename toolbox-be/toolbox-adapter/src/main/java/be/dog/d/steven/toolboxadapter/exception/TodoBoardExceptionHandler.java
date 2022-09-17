package be.dog.d.steven.toolboxadapter.exception;

import be.dog.d.steven.toolboxdatabase.model.exception.TodoBoardNotFoundException;
import be.dog.d.steven.toolboxdatabase.model.exception.TodoNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class TodoBoardExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TodoBoardNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleTodoBoardNotFound(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Todoboard not found.", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(TodoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleTodoNotFound(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Todo not found.", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}

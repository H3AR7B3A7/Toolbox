package be.dog.d.steven.toolboxdatabase.model.exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(String todoId) {
        super(String.format("Could not find Todo with id: %s", todoId));
    }
}

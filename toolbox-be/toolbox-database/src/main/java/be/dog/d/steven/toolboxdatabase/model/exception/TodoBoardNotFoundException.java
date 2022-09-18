package be.dog.d.steven.toolboxdatabase.model.exception;

public class TodoBoardNotFoundException extends RuntimeException {
    public TodoBoardNotFoundException(String todoBoardId) {
        super(String.format("Could not find TodoBoard with id: %s", todoBoardId));
    }
}

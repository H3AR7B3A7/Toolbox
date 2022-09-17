package be.dog.d.steven.toolboxdatabase.model;

import be.dog.d.steven.toolboxdatabase.model.exception.TodoNotFoundException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@ToString
public class TodoBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Getter
    private String todoBoardId = UUID.randomUUID().toString();

    @Getter
    @Setter
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "todoBoardId", referencedColumnName = "id")
    @ToString.Exclude
    private List<Todo> todos = new ArrayList<>();

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "toolboxUserId", referencedColumnName = "id", updatable = false)
    private ToolboxUser toolboxUser;

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public Todo updateTodo(String todoId, Todo todo) {
        Todo todoToUpdate = todos.stream()
                .filter(t -> t.getTodoId().equals(todoId))
                .findAny()
                .orElseThrow(() -> new TodoNotFoundException(todoId));
        todoToUpdate.setTitle(todo.getTitle());
        todoToUpdate.setBody(todo.getBody());
        return todoToUpdate;
    }

    public void removeTodo(String todoId) {
        Todo todo = todos.stream()
                .filter(t -> t.getTodoId().equals(todoId))
                .findAny()
                .orElseThrow(() -> new TodoNotFoundException(todoId));
        todos.remove(todo);
    }

    public void patchCompleted(String todoId) {
        Todo todo = todos.stream()
                .filter(t -> t.getTodoId().equals(todoId))
                .findAny()
                .orElseThrow(() -> new TodoNotFoundException(todoId));
        todo.setCompleted(!todo.isCompleted());
    }

    public List<Todo> getCopyOfTodos() {
        return List.copyOf(todos);
    }
    
}
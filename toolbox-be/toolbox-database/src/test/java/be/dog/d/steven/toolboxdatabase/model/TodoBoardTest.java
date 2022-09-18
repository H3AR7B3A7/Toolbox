package be.dog.d.steven.toolboxdatabase.model;

import be.dog.d.steven.toolboxdatabase.model.exception.TodoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TodoBoardTest {

    private TodoBoard todoBoard;

    @BeforeEach
    void setup() {
        todoBoard = createTodoBoard();
    }

    @Nested
    @DisplayName("Given a Todo Board")
    class Given {

        @Nested
        @DisplayName("When adding 3 todos")
        class WhenAdding {
            @Test
            @DisplayName("Then the size of todos is three, with 3 unique IDs")
            void testAddTodo() {
                final int iterations = 3;
                String[] ids = new String[iterations];

                for (int i = 0; i < iterations; i++) {
                    Todo todo = new Todo();
                    todo.setTitle("Test");
                    todo.setBody("Test");
                    ids[i] = todo.getTodoId();
                    todoBoard.addTodo(todo);
                }

                assertThat(todoBoard.getCopyOfTodos().size()).isEqualTo(iterations);
                for (String id : ids) {
                    assertThat(todoBoard.getCopyOfTodos().stream()
                                    .anyMatch(t -> t.getTodoId().equals(id)))
                            .isTrue();
                }
            }
        }

        @Nested
        @DisplayName("When removing a todo, if todos size was 3")
        class WhenDelete {
            @Test
            @DisplayName("Then todos size is 2")
            void testRemoveTodo() {
                Todo marked = createTodo("Marked");
                Todo unmarked = createTodo();
                todoBoard.addTodo(unmarked);
                todoBoard.addTodo(marked);
                todoBoard.addTodo(unmarked);

                todoBoard.removeTodo(marked.getTodoId());

                assertThat(todoBoard.getCopyOfTodos().size()).isEqualTo(2);
                assertThat(todoBoard.getCopyOfTodos().stream()
                                .noneMatch(t -> t.getTitle().equals("Marked")))
                        .isTrue();
            }
        }

        @Nested
        @DisplayName("When updating a todo")
        class WhenUpdate {
            @Test
            @DisplayName("Then name and body are updated")
            void testUpdateTodo() {
                Todo created = createTodo("Created");
                created.setBody("Created");
                todoBoard.addTodo(created);

                Todo updated = createTodo("NewTitle");
                updated.setBody("NewBody");
                System.out.println(created.getTodoId());
                System.out.println(todoBoard.getTodos());
                todoBoard.updateTodo(created.getTodoId(), updated);

                assertThat(todoBoard.getTodos().size()).isEqualTo(1);
                assertThat(todoBoard.getTodos().get(0).getTitle()).isEqualTo("NewTitle");
                assertThat(todoBoard.getTodos().get(0).getBody()).isEqualTo("NewBody");
            }
        }

        @Nested
        @DisplayName("When patching a todo")
        class WhenPatch {
            @Test
            @DisplayName("Then completed turns true when false and vice versa")
            void testPatchTodo() {
                Todo todo = createTodo();
                todoBoard.addTodo(todo);

                todoBoard.patchCompleted(todo.getTodoId());
                assertThat(todoBoard.getTodos().size()).isEqualTo(1);
                assertThat(todoBoard.getTodos().get(0).isCompleted()).isEqualTo(true);

                todoBoard.patchCompleted(todo.getTodoId());
                assertThat(todoBoard.getTodos().get(0).isCompleted()).isEqualTo(false);
            }
        }

        @Nested
        @DisplayName("When a todo does not exist")
        class WhenNotFound {
            @Test
            @DisplayName("Then an exception is thrown")
            void testPatchTodo() {
                Todo todo = createTodo();

                assertThrows(TodoNotFoundException.class, () -> todoBoard.updateTodo(todo.getTodoId(), todo));
                assertThrows(TodoNotFoundException.class, () -> todoBoard.removeTodo(todo.getTodoId()));
                assertThrows(TodoNotFoundException.class, () -> todoBoard.patchCompleted(todo.getTodoId()));
            }
        }
    }

    private TodoBoard createTodoBoard() {
        TodoBoard todoBoard = new TodoBoard();
        todoBoard.setTitle("");
        return todoBoard;
    }

    private Todo createTodo(String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        return todo;
    }

    private Todo createTodo() {
        return createTodo("");
    }
}
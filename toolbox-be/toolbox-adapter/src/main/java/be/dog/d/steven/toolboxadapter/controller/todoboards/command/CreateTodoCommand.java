package be.dog.d.steven.toolboxadapter.controller.todoboards.command;

import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateTodoCommand {
    @NotBlank(message = "placeholder")
    private String title;

    @NotBlank(message = "placeholder")
    private String body;
}

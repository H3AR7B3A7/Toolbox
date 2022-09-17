package be.dog.d.steven.toolboxadapter.controller.todoboards.command;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateTodoCommand {
    @NotBlank(message = "placeholder")
    private String title;

    @NotBlank(message = "placeholder")
    private String body;
}
package be.dog.d.steven.toolboxadapter.controller.todoboards.command;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateTodoBoardCommand {
    @NotBlank(message = "placeholder")
    private String title;
}
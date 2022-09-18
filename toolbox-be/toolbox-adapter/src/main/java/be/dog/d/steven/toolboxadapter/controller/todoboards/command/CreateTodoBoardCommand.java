package be.dog.d.steven.toolboxadapter.controller.todoboards.command;

import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateTodoBoardCommand {
    @NotBlank(message = "placeholder")
    private String title;
}

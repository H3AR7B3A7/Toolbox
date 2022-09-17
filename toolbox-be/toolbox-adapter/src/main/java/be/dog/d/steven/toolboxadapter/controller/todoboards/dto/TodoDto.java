package be.dog.d.steven.toolboxadapter.controller.todoboards.dto;

import lombok.Data;

@Data
public class TodoDto {
    private String todoId;
    private String title;
    private String body;
    private boolean completed;
}
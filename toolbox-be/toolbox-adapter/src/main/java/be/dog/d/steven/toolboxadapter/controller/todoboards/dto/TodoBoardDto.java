package be.dog.d.steven.toolboxadapter.controller.todoboards.dto;

import java.util.List;
import lombok.Data;

@Data
public class TodoBoardDto {
    private String todoBoardId;
    private String title;
    private List<TodoDto> todos;
}

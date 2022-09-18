package be.dog.d.steven.toolboxadapter.controller.todoboards;

import be.dog.d.steven.toolboxdatabase.model.TodoBoard;
import be.dog.d.steven.toolboxdomain.service.TodoBoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@UnsecuredWebMvcTest
@Import(TodoBoardController.class)
class TodoBoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoBoardService todoBoardService;

    @Nested
    @DisplayName("Given a GET")
    class Given {

        @Nested
        @DisplayName("When there is no todo board")
        class WhenEmpty {
            @Test
            @DisplayName("Then a 200 status and an empty list should be returned")
            void getCar_shouldReturnNotFound() throws Exception {
                given(todoBoardService.getAllTodoBoards()).willReturn(List.of());

                mockMvc.perform(get("/v1/todoboards"))
                        .andExpect(status().isOk())
                        .andExpect(content().string("[]"));
            }
        }

        @Nested
        @DisplayName("When a user has one todo board")
        class WhenOne {
            @Test
            @DisplayName("Then a 200 status and a list containing the todo board should be returned")
            void getAllTodoBoards() throws Exception {
                TodoBoard todoBoard = new TodoBoard();
                todoBoard.setTitle("Title");
                given(todoBoardService.getAllTodoBoards()).willReturn(List.of(todoBoard));

                mockMvc.perform(get("/v1/todoboards"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$[0].title").value("Title"));
            }
        }
    }
}
package be.dog.d.steven.toolboxadapter.controller.todoboards;

import be.dog.d.steven.toolboxadapter.mapper.TodoBoardMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {TodoBoardMapper.class})
public class TestApplication {
    // Provides SpringBootConfiguration for TodoBoardControllerTest
}

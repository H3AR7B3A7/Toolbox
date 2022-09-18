package be.dog.d.steven.toolboxdatabase.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"be.dog.d.steven"})
@EntityScan(basePackages = {"be.dog.d.steven"})
public class TestApplication {
    // Provides SpringBootConfiguration for TodoBoardRepositoryTest
}

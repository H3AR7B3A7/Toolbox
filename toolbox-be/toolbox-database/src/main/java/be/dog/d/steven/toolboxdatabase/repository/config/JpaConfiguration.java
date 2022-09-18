package be.dog.d.steven.toolboxdatabase.repository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"be.dog.d.steven"})
public class JpaConfiguration {}

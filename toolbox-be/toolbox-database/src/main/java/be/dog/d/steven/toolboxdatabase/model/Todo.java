package be.dog.d.steven.toolboxdatabase.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

@Entity
@Getter
@ToString
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    private String todoId = UUID.randomUUID().toString();

    @Setter
    private String title;

    @Setter
    private String body;

    @Setter
    private boolean completed;

    @Setter
    private Long todoBoardId;
}

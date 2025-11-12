package toDoAppYigit.demo.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private boolean completed = false;

    @Column(updatable = false)
    private LocalDateTime created = LocalDateTime.now();

    private LocalDateTime updated = LocalDateTime.now();

    public Task() {}

    public Task(String title, String description, boolean completed){
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }



}

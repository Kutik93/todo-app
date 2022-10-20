package com.github.kutik93.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "Task's description must be not empty")
    private String description;
    private boolean done;
    private LocalDateTime deadline;
    @Embedded
    private Audit audit = new Audit();
    @ManyToOne()
    @JoinColumn(name = "task_group_id")
    private TaskGroup group;

    public Task() {
    }
    public LocalDateTime getDeadline() {
        return deadline;
    }
    void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
    public Long getId() {
        return id;
    }
    void setId(final Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    void setDescription(String description) {
        this.description = description;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    TaskGroup getGroup() {
        return group;
    }
    public void updateFrom(final Task source) {
        description = source.description;
        done = source.done;
        deadline = source.deadline;
        group=source.group;
    }

}

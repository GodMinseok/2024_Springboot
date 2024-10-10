package org.example.daelim_spirng_todoapp_201930112.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.daelim_spirng_todoapp_201930112.domain.Task;

@NoArgsConstructor
@Getter
public class TaskViewResponse {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

    public TaskViewResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.completed = task.isCompleted();
    }
}

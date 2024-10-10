package org.example.daelim_spirng_todoapp_201930112.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.daelim_spirng_todoapp_201930112.domain.Task;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

    public TaskResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.completed = task.isCompleted();
    }
}

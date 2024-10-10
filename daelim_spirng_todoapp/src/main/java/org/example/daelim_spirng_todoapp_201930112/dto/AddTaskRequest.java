package org.example.daelim_spirng_todoapp_201930112.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.daelim_spirng_todoapp_201930112.domain.Task;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddTaskRequest {

    private String title;
    private String description;
    private boolean completed;

    public Task toEntity() {
        return Task.builder()
                .title(title)
                .description(description)
                .completed(completed)
                .build();
    }
}


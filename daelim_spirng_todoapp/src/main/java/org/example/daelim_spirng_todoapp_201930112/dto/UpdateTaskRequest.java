package org.example.daelim_spirng_todoapp_201930112.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateTaskRequest {
    private String title;
    private String description;
    private boolean completed;
}

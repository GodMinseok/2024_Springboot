package org.example.daelim_spirng_todoapp_201930112.controller;

import lombok.RequiredArgsConstructor;

import org.example.daelim_spirng_todoapp_201930112.domain.Task;
import org.example.daelim_spirng_todoapp_201930112.dto.AddTaskRequest;
import org.example.daelim_spirng_todoapp_201930112.dto.TaskResponse;
import org.example.daelim_spirng_todoapp_201930112.dto.UpdateTaskRequest;
import org.example.daelim_spirng_todoapp_201930112.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/api/tasks")
    public ResponseEntity<List<TaskResponse>> findAllTasks() {
        List<TaskResponse> taskResponses = taskService.findAll().stream()
                .map(TaskResponse::new)
                .toList();
        return ResponseEntity.ok().body(taskResponses);
    }

    @GetMapping("/api/tasks/{id}")
    public ResponseEntity<TaskResponse> findTask(@PathVariable long id) {
        Task task = taskService.findById(id);
        return ResponseEntity.ok().body(new TaskResponse(task));
    }

    @PostMapping("/api/tasks")
    public ResponseEntity<Task> addTask(@RequestBody AddTaskRequest addTaskRequest) {
        Task task = taskService.save(addTaskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @DeleteMapping("/api/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody UpdateTaskRequest request) {
        Task updatedTask = taskService.update(id, request);
        return ResponseEntity.ok().body(updatedTask);
    }

}



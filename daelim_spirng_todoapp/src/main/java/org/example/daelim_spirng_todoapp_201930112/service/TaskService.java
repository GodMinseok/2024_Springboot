package org.example.daelim_spirng_todoapp_201930112.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.daelim_spirng_todoapp_201930112.domain.Task;
import org.example.daelim_spirng_todoapp_201930112.dto.AddTaskRequest;
import org.example.daelim_spirng_todoapp_201930112.dto.UpdateTaskRequest;
import org.example.daelim_spirng_todoapp_201930112.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task save(AddTaskRequest request) {
        return taskRepository.save(request.toEntity());
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(long id) {
        return taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found: " + id));
    }

    public void delete(long id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public Task update(long id, UpdateTaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found: " + id));
        task.update(request.getTitle(), request.getDescription(), request.isCompleted());
        return task;
    }
}


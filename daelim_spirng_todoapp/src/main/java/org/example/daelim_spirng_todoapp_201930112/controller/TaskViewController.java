package org.example.daelim_spirng_todoapp_201930112.controller;

import lombok.RequiredArgsConstructor;
import org.example.daelim_spirng_todoapp_201930112.domain.Task;
import org.example.daelim_spirng_todoapp_201930112.dto.TaskResponse;
import org.example.daelim_spirng_todoapp_201930112.dto.TaskViewResponse;
import org.example.daelim_spirng_todoapp_201930112.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskViewController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public String tasks(Model model) {
        List<TaskResponse> tasks = taskService.findAll().stream()
                .map(TaskResponse::new)
                .toList();
        model.addAttribute("tasks", tasks);
        return "taskList";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", new TaskViewResponse(taskService.findById(id)));
        return "task";
    }

    @GetMapping("/new-task")
    public String newTask(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("task", new TaskViewResponse());
        } else {
            Task task = taskService.findById(id);
            model.addAttribute("task", task);
        }
        return "newTask";
    }

    @GetMapping("/new-tasks/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Task task = taskService.findById(id);
        model.addAttribute("task", new TaskViewResponse(task));
        return "newTask";
    }
}


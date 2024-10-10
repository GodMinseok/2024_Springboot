package org.example.daelim_spirng_todoapp_201930112.repository;

import org.example.daelim_spirng_todoapp_201930112.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}


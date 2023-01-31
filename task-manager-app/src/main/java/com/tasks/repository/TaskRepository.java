package com.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasks.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}

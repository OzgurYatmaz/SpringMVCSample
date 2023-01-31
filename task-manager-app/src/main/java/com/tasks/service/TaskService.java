package com.tasks.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.model.Task;
import com.tasks.repository.TaskRepository;

import jakarta.validation.Valid;

@Service
public class TaskService {
	
 
	@Autowired
	private TaskRepository taskRepository;
	public void addTask(String username, String description, LocalDate targetDate, boolean done) {
		Task task=new Task( username, description, targetDate, done);
		taskRepository.save(task);
	}
	public List<Task> findAllTasks(){
		return taskRepository.findAll();
	}
	public void deleteTaskById(int id) {
		taskRepository.deleteById(id);
	}
	
	public Task findTaskById(int id) {
		return taskRepository.findById(id).get();
	}
	public void updateTask(@Valid Task task) {
		deleteTaskById(task.getId());
		addTask(task.getUsername(),task.getDescription(), task.getTargetDate(), task.isDone());
	}
 
}
package com.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tasks.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	// @Query( "SELECT * FROM Task WHERE Task.user_id = :user_id")
	// public List<Task> findByUser_idOrderByDescription(@Param("user_id") String
	// userId);

	// public List<Task> findByUser_idOrderByGivenDate(@Param("user_id") String
	// userId);
	public List<Task> findByUser_idOrderByTargetDate(@Param("user_id") String userId);
}

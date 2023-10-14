package com.tasks.model;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;
	private String username;
	@Size(min = 3, message = "At least 3 characters")
	private String description;
	private LocalDate givenDate;
	private LocalDate targetDate;
	@Transient // to disable jpa to create a column in DB
	private String remainingTime;
	@Transient
	private int priority;
	private boolean done;

	@ManyToOne // (fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private AppUser user;

	public Task() {
		super();
	}

	public Task(String username, String description, LocalDate targetDate, LocalDate givenDate, boolean done) {
		super();
		// this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.givenDate = givenDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getGivenDate() {
		return givenDate;
	}

	public void setGivenDate(LocalDate givenDate) {
		this.givenDate = givenDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public String getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(String remainingTime) {
		this.remainingTime = remainingTime;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + ", user=" + user + "]";
	}

}
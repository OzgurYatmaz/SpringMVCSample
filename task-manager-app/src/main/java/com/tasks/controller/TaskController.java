package com.tasks.controller;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tasks.model.AppUser;
import com.tasks.model.Task;
import com.tasks.repository.UserRepository;
import com.tasks.service.TaskService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("tasks")
	public String listAllTasks(ModelMap model) {
		String username = getLoggedInUsername();
		AppUser user = userRepository.findByName(username).get(0);
		
		List<Task> tasks = taskService.findAllTasksForSpecificUser(Integer.toString(user.getId()));
		getRemainingTimes(tasks);//tasks.stream().map(t->Period.between(LocalDate.now(),t.getTargetDate());
		model.put("tasks", tasks);
		return "taskList";
	}
	
	private void getRemainingTimes(List<Task> tasks) {
		for(Task t:tasks) {
			Period period = Period.between(LocalDate.now(),t.getTargetDate());
			String diff=null;
			if(t.isDone()) {
				diff="Accomplished!";
			}else {
				if(!period.isNegative()) {
				diff=period.getYears() + " years, "+period.getMonths() + " months, "+period.getDays() + " days";
				}else {
					diff="Expired!";
				}
		    }
			t.setRemainingTime(diff);
		}
	}

	@RequestMapping(value="add-task",method = RequestMethod.GET)
	public String showNewTaskPage(ModelMap model) {
		String username = getLoggedInUsername();
		Task task=new Task(username, "", LocalDate.now(), LocalDate.now(), false);
		model.put("task", task);
		return "task";
	}


	
	@RequestMapping(value="addTask",method = RequestMethod.POST)
	public String addNewTask(ModelMap model, @Valid Task task, BindingResult reult) {
		if (reult.hasErrors()) {
			return "task";
		}
		String username = getLoggedInUsername();
		AppUser user = userRepository.findByName(username).get(0);
		taskService.addTask(username, task.getDescription(), task.getTargetDate(), task.isDone(), user);
		return "redirect:tasks";
	}
	
	@RequestMapping("updateTask")
	public String updateTask(ModelMap model, @RequestParam int id) {
		Task task = taskService.findTaskById(id);
		model.put("task", task);
		return "updateTask";
	}
	
	
	@RequestMapping(value="updateTask",method = RequestMethod.POST)
	public String updateTask(ModelMap model, @Valid Task task, BindingResult reult) {
		if (reult.hasErrors()) {
			return "updateTask";
		}
		
		String username = getLoggedInUsername();
		AppUser user = userRepository.findByName(username).get(0);
		
		task.setUsername(username);
		task.setUser(user);
		taskService.updateTask(task);
		return "redirect:tasks";
	}
	
	@RequestMapping(value="deleteTask")
	public String deleteTask(@RequestParam int id) {
		taskService.deleteTaskById(id);
		return "redirect:tasks";
	}
	
	
	private String getLoggedInUsername() {//ModelMap model) {
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
}	
package com.tasks.controller;

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

import com.tasks.model.AppUser;
import com.tasks.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/showAddUserPage", method = RequestMethod.GET)
	private String ShowAddUserPage(ModelMap model) {
		AppUser u=new AppUser();
		u.setEmail("");
		u.setName("");
		u.setPassword("");
		u.setRole("");
		model.put("user", u);
		return "user";
	}

	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public String addNewUser(ModelMap model, AppUser user, BindingResult reult) {
		if (reult.hasErrors()) {
 
			return "user";
		}
		userService.saveUser(user);
		return "redirect:showAllUsers";
	}

	@RequestMapping(value = "/showAllUsers", method = RequestMethod.GET)
	private String ShowAllUsers(ModelMap model) {
		List<AppUser> allUsers = userService.getAllUsers();
		addCount(allUsers);
		model.put("users", allUsers);
		return "userList";
	}
	
	private void addCount(List<AppUser> allUsers) {
		int c=1;
		for(AppUser a:allUsers) {
			a.setCount(c);
			c++;
		}
	}

	@RequestMapping(value="deleteUser")
	public String deleteTask(@RequestParam int id) {
		userService.deleteUserById(id);
		return "redirect:showAllUsers";
	}
	private String getLoggedinUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();

	}
}

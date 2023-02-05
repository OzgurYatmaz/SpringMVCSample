package com.tasks.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tasks.model.AppUser;
import com.tasks.repository.UserRepository;

@Service
public class UserService {
	
 
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void saveUser(AppUser user) {
		String password = user.getPassword();
		String role = user.getRole();
		user.setPassword(passwordEncoder.encode(password));
		user.setRole(role.toUpperCase());
		userRepository.save(user);
	}
 
	public List<AppUser> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}
}
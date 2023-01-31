package com.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasks.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

	/*
	 * jpa is sensitive to "findBy" part and takes the where condition from 
	 * the remaider part of the method name(email in this case). 
	 * 
	 * that is called derived method name query
	 */
	List<AppUser> findByEmail(String email);
	
	List<AppUser> findByName(String name);
}

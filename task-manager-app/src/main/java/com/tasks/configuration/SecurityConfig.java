package com.tasks.configuration;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	

//	@Bean
//	public InMemoryUserDetailsManager createUserDetailsMenager() {
//		
//		Function<String, String> paswordEncoderFunc
//								=input -> passwordEncoder().encode(input);
//		
//		UserDetails userDetails =User.builder()
//				.passwordEncoder(paswordEncoderFunc)
//				.username("Abdulahir")
//				.password("622")
//				.roles("USER","ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(userDetails);
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

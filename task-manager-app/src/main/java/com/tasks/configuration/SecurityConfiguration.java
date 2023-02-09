package com.tasks.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.requestMatchers("/showAddUserPage","/addUser","/showAllUsers").hasAnyAuthority("ADMIN","OWNER")//hasRole("ROLE_ADMIN")//@PreAuthorize("hasRole('ROLE_ADMIN')") is used instead
			.requestMatchers("/deleteUser").hasAuthority("OWNER")
			.anyRequest()
			.authenticated()
			.and().formLogin()
			.and().httpBasic();
	 
		return http.build();
		
	}	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

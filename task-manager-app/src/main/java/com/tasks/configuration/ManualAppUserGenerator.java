package com.tasks.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ManualAppUserGenerator {

	public static void main(String[] args) {
		 BCryptPasswordEncoder enc= new BCryptPasswordEncoder();
		 System.out.println(enc.encode("622"));
	}

}

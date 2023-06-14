package com.tasks;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasGen {

	public static void main(String[] args) {
		BCryptPasswordEncoder en=new BCryptPasswordEncoder();
		System.out.println(en.encode("622"));
	}

}
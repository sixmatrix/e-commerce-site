package com.bolton.treehouseproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TreehouseprojectApplication {
	
	// Runs the application

	public static void main(String[] args) {
		SpringApplication.run(TreehouseprojectApplication.class, args);
	}
	
	// Implements a bean for a password encoder
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
}
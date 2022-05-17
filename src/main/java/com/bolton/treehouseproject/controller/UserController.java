package com.bolton.treehouseproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolton.treehouseproject.domains.User;
import com.bolton.treehouseproject.repositories.UserRepository;
import com.bolton.treehouseproject.services.UserService;

@Controller

public class UserController {
	
	// Injects objects implicitally 
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired 
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(path="/register")
	public String registerPage() {
		
		return "register";
	}
	
	@RequestMapping(path="/register_user")
	public String register(@RequestParam String userName, String userEmail, String userPass) {
		
		User userEntity = new User(userName, userEmail, passwordEncoder.encode(userPass));
		userRepository.save(userEntity);
			
		return "redirect:/";
	}
	
	@RequestMapping(path="/login")
	public String loginPage() {
		
		return "login";
	}
	
	@RequestMapping(path="/login_user")
	public String login(@RequestParam String userEmail, String userPass, HttpSession session) {
		
		// If user is validated, add user to session
		
		String userName = userService.validateUserDetails(userEmail, userPass);
		if (userName == null) {
			
			return "redirect:/";
		}
		
		session.setAttribute("userName", userName);
		session.setAttribute("userEmail", userEmail);
		session.setAttribute("userPass", userPass);
		
		return "redirect:/";
	}
	

	@RequestMapping(path="/logout")
	public String logout(HttpSession session) {
		
		// Close the session
		
		session.invalidate();
		
		return "redirect:/";
	}
}

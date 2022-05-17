package com.bolton.treehouseproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bolton.treehouseproject.domains.User;
import com.bolton.treehouseproject.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String validateUserDetails(String userEmail, String userPass) {
		
		String userName = null;
		for (User user : userRepository.findAll()) {
			if (user.getUserEmail().equals(userEmail) & passwordEncoder.matches(userPass, user.getUserPass())) {
				userName = user.getUserName();
			}
		}
		
		return userName;
		
	}
}

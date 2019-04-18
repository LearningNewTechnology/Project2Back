package com.java.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@PostMapping
	public User getUser(String username) {
		return null;
	}
	
	@GetMapping
	public List<User> getUsers() {
		return null;
	}
	
	@PostMapping
	public void addUser(User user) {
		
	}
	
	@PostMapping
	public void updateUser(User user) {
		
	}
	
}

package com.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.java.dto.User;
import com.java.service.UserService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/getUser.do")
	public User getUser(String username) {
		User user = null;
		user = service.getUser(username);
		return user;
	}
	
	@GetMapping("/getUsers.do")
	public List<User> getUsers() {
		List<User> list = null;
		list = service.getUsers();
		return list;
	}
	
	@PutMapping("/updateUser.do")
	public void updateUser(User user) {
		service.updateUser(user);
	}
	
}

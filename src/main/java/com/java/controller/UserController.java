package com.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.User;
import com.java.service.UserService;

@RestController
@CrossOrigin(origins = "*")
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
	public User updateUser(@RequestBody User user, HttpServletRequest request) {
		User currUser = (User) request.getSession().getAttribute("User");
		if (currUser != null) {
			user.setId(currUser.getId());
			service.updateUser(user);
			return user;
		}
		else {
			return new User();
		}
	}

}

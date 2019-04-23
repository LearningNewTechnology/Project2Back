package com.java.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.User;
import com.java.service.LoginService;

@RestController
@CrossOrigin(origins="*")
public class LoginController {
	@Autowired
	private LoginService service;

	@PostMapping(value = "/login.do")
	public User login(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
		User currUser = null;
		currUser = service.login(user.getUsername(), user.getPassword());
		
		System.out.println("currUser = "+ currUser);
		System.out.println("user = "+ user);
		if (currUser != null && user.getUsername().equals(currUser.getUsername()) && user.getPassword().equals(currUser.getPassword())) {
			request.getSession().setAttribute("User", currUser);
			return currUser;
		}else {
			//response.getWriter().println("Invalid login");
			return new User();
		}
		//return null;
	}
	
	@GetMapping("/login.do")
	public String testGet() {
		return "login";
	}
}

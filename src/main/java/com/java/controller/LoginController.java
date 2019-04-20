package com.java.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.User;
import com.java.service.LoginService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	@Autowired
	private LoginService service;

	@PostMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute User user/*@RequestParam String username, @RequestParam String password*/) {
		/*User user = null;
		user = new User();
		user.setUsername(username);
		user.setPassword(password);*/
		//user = service.login(username, password);
		System.out.println(user);
		if (user != null && "jtran".equals(user.getUsername()) && "pass".equals(user.getPassword())) {
			System.out.println("Login successful");
			request.getSession().setAttribute("User", user);
			return "home";
		}
		/*if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
			request.getSession().setAttribute("User", user);
			return "forward:/home";
		}else {
			try {
				response.getWriter().println("Invalid login");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}*/
		return null;
	}
	
	@GetMapping("/login.do")
	public String testGet() {
		return "login";
	}
}

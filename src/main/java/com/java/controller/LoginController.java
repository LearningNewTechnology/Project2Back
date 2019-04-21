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
	public String login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute User user) {
		User currUser = null;
		currUser = service.login(user.getUsername(), user.getPassword());
		
		System.out.println("currUser = "+ currUser);
		System.out.println("user = "+ user);
		if (currUser != null && user.getUsername().equals(currUser.getUsername()) && user.getPassword().equals(currUser.getPassword())) {
			request.getSession().setAttribute("User", user);
			return "home";
		}else {
			try {
				response.getWriter().println("Invalid login");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@GetMapping("/login.do")
	public String testGet() {
		return "login";
	}
}

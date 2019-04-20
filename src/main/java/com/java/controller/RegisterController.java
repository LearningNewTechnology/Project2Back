package com.java.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.User;
import com.java.service.LoginService;
import com.java.service.RegisterService;

@Controller
@RequestMapping("/register.do")
@CrossOrigin(origins="http://localhost:4200")
public class RegisterController {

	@Autowired
	private RegisterService service;

	@PostMapping
	public String registerUser(@Valid @ModelAttribute User user, BindingResult result, HttpServletResponse response) {
		if (result.hasErrors()) {
			// response.getWriter().println(result.getAllErrors().stream().map(x ->
			// x.getDefaultMessage()).collect(collector));

			return "forward:register";
		} else {
			try {
				service.addUser(user);
				response.getWriter().println("Inserted successfully");
				return "forward:/login";
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		return null;
	}

}

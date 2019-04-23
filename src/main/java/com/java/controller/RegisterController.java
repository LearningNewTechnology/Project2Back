package com.java.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.User;
import com.java.service.RegisterService;


@RestController
@RequestMapping("/register.do")
@CrossOrigin(origins="*")
public class RegisterController {

	
	@Autowired
	private RegisterService service;

	@PostMapping(produces="application/text")
	public String registerUser(@Valid @RequestBody User user, BindingResult result, HttpServletResponse response) {
		if (result.hasErrors()) {
			// response.getWriter().println(result.getAllErrors().stream().map(x ->
			// x.getDefaultMessage()).collect(collector));
			//System.out.println(user);
			return "Fail";
		} else {
			try {
				service.addUser(user);
				response.getWriter().println("Inserted successfully");
				return "Success";
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		return null;
	}

}

package com.java.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.User;
import com.java.service.UserService;
import com.java.util.UploadUtil;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService service;
	@Autowired
	UploadUtil util;

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
	public User updateUser(@RequestBody User user, @RequestParam(required=false) MultipartFile file,HttpServletRequest request) {
		User currUser = (User) request.getSession().getAttribute("User");
		if (currUser != null) {
			user.setId(currUser.getId());
			if(file != null)
				user.setProfilePic(util.uploadFile(file));
			
			service.updateUser(user);
			return user;
		}
		else {
			return new User();
		}
	}

	@GetMapping("/searchUsers.do")
	public Set<User> searchUsers(@RequestBody String username){
		return null;
	}
}

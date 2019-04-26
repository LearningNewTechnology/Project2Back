package com.java.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Post;
import com.java.dto.User;
import com.java.service.PostService;
import com.java.util.UploadUtil;

@RestController
@CrossOrigin(origins = "*")
public class PostController {
	@Autowired
	PostService service;
	@Autowired
	UploadUtil util;

	@GetMapping("/getPost.do")
	public Post getPost(@RequestParam int id) {
		return service.getPost(id);
	}

	@GetMapping("/getPosts.do")
	public List<Post> getPosts() {
		return service.getPosts();
	}

	@GetMapping("/getUserPosts.do")
	public List<Post> getPostsFromListUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("User");
		return service.getPostsFromListUser(user.getId());
	}

	@PostMapping("/addPost.do")
	public Post addPost(@RequestParam(required=false, name="file") MultipartFile file, @ModelAttribute Post post, HttpServletRequest request) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm/dd/yyyy hh:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		User user = (User) request.getSession().getAttribute("User");
		if (user != null) {
			post.setAuthorId(user.getId());
			post.setPostedDate(now);
			if(file != null)
				post.setPicture(util.uploadFile(file));
			
			//System.out.println(post);
			service.addPost(post);
			return post;
		}
		else {
			return new Post();
		}
	}

	public void updatePost() {

	}
}

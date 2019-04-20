package com.java.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Post;

@Controller
@RequestMapping("/posts.do")
@CrossOrigin(origins="http://localhost:4200")
public class PostController {
	
	public Post getPost() {
		return null;
	}
	
	public List<Post> getPosts(){
		return null;
	}
	
	public void addPost() {

	}
	
	public void updatePost() {
		
	}
	
	public void likePost() {
		
	}
	
	public void unLikePost() {
		
	}
}

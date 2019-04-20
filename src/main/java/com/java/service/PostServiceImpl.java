package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Post;
import com.java.repository.PostRepository;

//@Service
public class PostServiceImpl implements PostService{

	//@Autowired PostRepository rep;
	@Override
	public Post getPost(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPost(Post post) {
		// TODO Auto-generated method stub
		
	}

}

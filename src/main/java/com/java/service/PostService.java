package com.java.service;

import java.util.List;

import com.java.dto.Post;

public interface PostService {
	public Post getPost(int id);
	public List<Post> getPosts();
	public void addPost(Post post);
}

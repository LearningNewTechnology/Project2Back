package com.java.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.dto.Post;

public interface PostService {
	public Post getPost(int id);

	public List<Post> getPosts();

	public void addPost(Post post);

	public List<Post> getPostsFromListUser(int id);

	public void updatePost();

	public void likePost();

	public void unLikePost();
}

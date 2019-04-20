package com.java.repository;

import java.util.List;

import com.java.dto.Post;

public interface PostRepository {
	public Post getPostById(int postId);
	public List<Post> getPostsOfUser(int userId);
	public Post updatePost(Post currPost);
	public Post insertPost(Post currPost);
	//public void deletePost(int postId);
}

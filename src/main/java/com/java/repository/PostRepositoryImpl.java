package com.java.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dto.Post;

//@Repository
public class PostRepositoryImpl implements PostRepository{

	//@Autowired
	@Override
	public Post getPostById(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsOfUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updatePost(Post currPost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post insertPost(Post currPost) {
		// TODO Auto-generated method stub
		return null;
	}

}

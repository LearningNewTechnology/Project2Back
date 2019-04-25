package com.java.repository;

import java.util.List;

import com.java.dto.Like;

public interface LikeRespository {
	public void insertLike(int userId, int postId);
	public void deleteLike(int userId, int postId);
	public int likesbyPost(int postId);
	public List<Like> userLikes(int userId);
}

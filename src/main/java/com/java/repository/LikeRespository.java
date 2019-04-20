package com.java.repository;

import com.java.dto.Like;

public interface LikeRespository {
	public void insertLike(int userId, int postId);
	public void deleteLike(int userId, int postId);
	public int likesbyPost(int postId);
	public Like userLikes(int userId, int postId);
}

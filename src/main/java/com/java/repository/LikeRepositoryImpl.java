package com.java.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dto.Like;

//@Repository
public class LikeRepositoryImpl implements LikeRespository{

	//@Autowired
	@Override
	public void insertLike(int userId, int postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLike(int userId, int postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int likesbyPost(int postId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Like> userLikes(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

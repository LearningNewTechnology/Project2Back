package com.java.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dto.Like;

@Repository
public class LikeRepositoryImpl implements LikeRespository{

	@Autowired 
	@Qualifier("sessionFactory")
	SessionFactory sf;
	
	@Override
	public void insertLike(Like like) {
		Session s=sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(like);
		tx.commit();
	}

	@Override
	public void deleteLike(Like like) {
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

package com.java.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dto.Post;

@Repository
public class PostRepositoryImpl implements PostRepository{

	@Autowired 
	@Qualifier("sessionFactory")
	SessionFactory sf;
	@Override
	public Post getPostById(int postId) {
		Session s = sf.openSession();
		Query<Post> q = s.createQuery("From Post Where id = :pId", Post.class);
		q.setParameter("pId", postId);
		Post currPost = q.uniqueResult();
		s.close();
		return currPost;
	}

	@Override
	public List<Post> getPostsOfUser(int userId) {
		Session s = sf.openSession();
		Query<Post> q = s.createQuery("From Post Where authorId = :uId", Post.class);
		q.setParameter("uId", userId);
		List<Post> posts = q.list();
		s.close();
		return posts;
	}

	//@Transactional
	@Override
	public void updatePost(Post currPost) {
		Session s=sf.openSession();
		Transaction tx = s.beginTransaction();
		s.update(currPost);
		tx.commit();
		s.close();
	}

	@Override
	public void insertPost(Post currPost) {
		Session s=sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(currPost);
		tx.commit();
		s.close();
	}

	@Override
	public List<Post> getPosts() {
		Session s = sf.openSession();
		Query<Post> q = s.createQuery("From Post", Post.class);
		List<Post> posts = q.list();
		s.close();
		return posts;
	}

}

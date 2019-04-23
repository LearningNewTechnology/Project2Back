package com.java.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dto.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Autowired 
	@Qualifier("sessionFactory")
	SessionFactory sf;
	
	@Override
	public User getUserByUsername(String username/*, String hashedPassword*/) {
		Session s = sf.openSession();
		//Query<User> q = s.createQuery("From User Where username = :uName And password = :uPass", User.class);
		Query<User> q = s.createQuery("From User Where username = :uName", User.class);
		q.setParameter("uName", username);
		//q.setParameter("uPass", hashedPassword);
		User currUser = q.uniqueResult();
		s.close();
		return currUser;
	}

	@Override
	public User getUserById(int userId) {
		Session s = sf.openSession();
		Query<User> q = s.createQuery("From User Where id = :uId", User.class);
		q.setParameter("uId", userId);
		User currUser = q.uniqueResult();
		s.close();
		return currUser;	
	}

	@Override
	public void registerUser(User newUser) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(newUser);
		tx.commit();
		s.close();
	}

	@Override
	public void updateUser(User currUser) {
		
		Session s=sf.openSession();
		Transaction tx = s.beginTransaction();
		//s.merge(currUser);
		s.update(currUser);
		tx.commit();
		s.close();
	}

	@Override
	public List<User> getUsers() {
		Session s = sf.openSession();
		Query<User> q = s.createQuery("From User", User.class);
		List<User> list = q.list();
		s.close();
		return list;
	}
}

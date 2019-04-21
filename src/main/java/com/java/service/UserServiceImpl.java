package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.User;
import com.java.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserRepository rep;
	@Override
	public User getUser(String username) {
		return rep.getUserByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		return rep.getUsers();
	}

	@Override
	public void updateUser(User user) {
		rep.updateUser(user);
	}

}

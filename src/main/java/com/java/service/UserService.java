package com.java.service;

import java.util.List;

import com.java.dto.User;

public interface UserService {
	public User getUser(String username);
	public List<User> getUsers();
	public void addUser(User user);
	public void updateUser(User user);
}
package com.java.repository;

import com.java.dto.User;

public interface UserRepository {
	public User getUser(String usrname/*, String hashedPassword*/);
	public User getUserById(int userId);
	public void registerUser(User newUser);
	public void updateUser(User currUser);
}

package com.derrick.demo.services;

import java.util.List;

import com.derrick.demo.models.User;

public interface UserService {

	User createUser(User user);
	User getUser(long userId);
	User updateUser(long userId, User user);
	int deleteUser(long userId);
	List<User> listUsers(int page);
}

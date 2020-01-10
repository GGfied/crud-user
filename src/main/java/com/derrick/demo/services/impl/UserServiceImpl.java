package com.derrick.demo.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derrick.demo.controllers.exceptions.UserNotFoundException;
import com.derrick.demo.models.User;
import com.derrick.demo.repositories.UserRepository;
import com.derrick.demo.services.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(User user) {

		return this.userRepo.save(user);
	}

	@Override
	public User getUser(long userId) {

		return this.userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(userId));
	}

	@Override
	public User updateUser(long userId, User user) {

		User updatedUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(userId));

		updatedUser.setName(user.getName());
		updatedUser.setUsername(user.getUsername());

		return this.userRepo.save(updatedUser);
	}

	@Override
	public int deleteUser(long userId) {

		this.userRepo.findById(userId)
		.orElseThrow(() -> new UserNotFoundException(userId));
		this.userRepo.deleteById(userId);

		return 1;
	}

	@Override
	public List<User> listUsers(int page) {

		return this.userRepo.findAll();
	}

}

package com.springjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjava.entity.User;
import com.springjava.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public void saveAll(List<User> userList) {
		userRepo.saveAll(userList);
	}

	@Override
	public int userDeleteByEmail(String email) {
		return userRepo.userDeleteByEmail(email);
	}

	@Override
	public int userDeleteByActive(boolean active) {
		return userRepo.userDeleteByActive(active);
	}

}

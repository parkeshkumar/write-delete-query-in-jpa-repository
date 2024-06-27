package com.springjava.service;

import java.util.List;

import com.springjava.entity.User;

public interface UserService {
	void saveAll(List<User> userList);

	int userDeleteByEmail(String email);

	int userDeleteByActive(boolean active);
}

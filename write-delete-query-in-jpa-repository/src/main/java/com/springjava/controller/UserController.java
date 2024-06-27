package com.springjava.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjava.entity.User;
import com.springjava.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/save-all")
	public ResponseEntity<?> save(@RequestBody List<User> users) {
		Map<String, Object> respUser = new LinkedHashMap<String, Object>();
		userService.saveAll(users);
		respUser.put("status", 1);
		respUser.put("message", "Record is Saved Successfully!");
		return new ResponseEntity<>(respUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete-by-email/{email}")
	public ResponseEntity<?> deleteByEmail(@PathVariable String email) {
		Map<String, Object> respUser = new LinkedHashMap<String, Object>();
		int count=userService.userDeleteByEmail(email);
		respUser.put("status", 1);
		respUser.put("data", count+" Record is deleted successfully!");
		return new ResponseEntity<>(respUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-by-active/{active}")
	public ResponseEntity<?> deleteByEmail(@PathVariable boolean active) {
		Map<String, Object> respUser = new LinkedHashMap<String, Object>();
		int count=userService.userDeleteByActive(active);
		respUser.put("status", 1);
		respUser.put("data", count+" Records are deleted successfully!");
		return new ResponseEntity<>(respUser, HttpStatus.OK);
	}

}

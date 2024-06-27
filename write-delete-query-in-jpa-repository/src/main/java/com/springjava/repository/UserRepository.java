package com.springjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springjava.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
	@Transactional
	@Modifying
	@Query("DELETE FROM User us WHERE us.email = :email")
	int userDeleteByEmail(String email);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM user_tbl WHERE active = :active", nativeQuery = true)
	int userDeleteByActive(boolean active);

}

package com.ibm.security.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.security.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

//	@Query("select u from user u where u.username = : username")
//	public User getUserByUserName(@Param("username") String username);
	
	public Optional<User> getByUsername(String username);
}

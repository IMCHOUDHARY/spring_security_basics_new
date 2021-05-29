package com.ibm.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.security.dao.UserRepository;
import com.ibm.security.dto.User;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepo;
	
	public User getUserName(String username)
	{
		return userRepo.getByUsername(username).get();
	}
	
	public void addUser(User user)
	{
		userRepo.save(user);
	}
}

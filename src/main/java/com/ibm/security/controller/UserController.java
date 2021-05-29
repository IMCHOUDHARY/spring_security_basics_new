package com.ibm.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.security.dto.User;
import com.ibm.security.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userCheck;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// user.setPassword(passwordEncoder.encode(user.getPassword()));
	
	@GetMapping("/test")
	public String check()
	{
		return "Hello This Is Testing";
	}
	
	@GetMapping("/user/{username}")
	public User getUser(@PathVariable(name = "username") String username )
	{
		return userCheck.getUserName(username);
	}
	
	@PostMapping("/adduser")
	public void addUser(@RequestBody User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userCheck.addUser(user);
	}
}

package com.ibm.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ibm.security.dao.UserRepository;
import com.ibm.security.dto.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.getByUsername(username).get();
		
		if(user==null)
		{
			throw new UsernameNotFoundException("Could not found user !!");
		}
		
		UserDetailsImpl customUserDetails = new UserDetailsImpl(user);
		return customUserDetails;
	}

}

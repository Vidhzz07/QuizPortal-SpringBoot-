package com.example.ExamPortalApis.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ExamPortalApis.entites.User;
import com.example.ExamPortalApis.repos.UserRepo;



@Service 
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user  = userRepo.findByEmail(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("Invalid Email or password");
		}
		
		else return user;
		
		
	}
	

}

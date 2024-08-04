package com.example.ExamPortalApis.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.ExamPortalApis.entites.User;
import com.example.ExamPortalApis.entites.UserRole;


@Service
public interface UserService {
	
	
	public User createUser(User user,Set<UserRole>userRoles) throws Exception;
	
	
	public User getUser(String username);
	
	
	public void deleteUser(Long userID);
	
	public User updateUser(Long userID,User user);

}

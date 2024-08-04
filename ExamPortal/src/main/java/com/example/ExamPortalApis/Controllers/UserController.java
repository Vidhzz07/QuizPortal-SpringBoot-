package com.example.ExamPortalApis.Controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExamPortalApis.entites.Role;
import com.example.ExamPortalApis.entites.User;
import com.example.ExamPortalApis.entites.UserRole;
import com.example.ExamPortalApis.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception
	{
		Set<UserRole>userRoles=new HashSet<>();
		
		Role role = new Role(1L,"NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		userRoles.add(userRole);
		
		
		return userService.createUser(user, userRoles);
		
	}
	
	
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") String username)
	{
		return userService.getUser(username);
	}
	
	@PutMapping("/{userID}")
	public User updateUser(@PathVariable("userID") Long userID,@RequestBody User user)
	{
		return userService.updateUser(userID, user);
	}
	
	
	
	
	@DeleteMapping("/{userID}")
	public void deleteUser(@PathVariable("userID") Long userID)
	{
		userService.deleteUser(userID);
	}
	
	
	

}

package com.example.ExamPortalApis.services.implementations;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExamPortalApis.entites.User;
import com.example.ExamPortalApis.entites.UserRole;
import com.example.ExamPortalApis.repos.RoleRepo;
import com.example.ExamPortalApis.repos.UserRepo;
import com.example.ExamPortalApis.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		
		User localUser = userRepo.findByEmail(user.getEmail());
		
		if(localUser!=null)
		{
			throw new Exception("User already present");
		}
		else {
			for(UserRole ur:userRoles)
			{
				roleRepo.save(ur.getRole());
			}
			
			user.setUserRoles(userRoles);
			
			 localUser = userRepo.save(user);
		}
		
		
		
		return localUser;
	}

	@Override
	public User getUser(String email) {
		
		return userRepo.findByEmail(email);
	}

	@Override
	public void deleteUser(Long userID) {
		
		userRepo.deleteById(userID);
	}

	@Override
	public User updateUser(Long userID, User user) {
		
		 User local = userRepo.findByUserID(userID);
		 if(user.getEmail()!=null)local.setEmail(user.getEmail());
		 if(user.getFirstName()!=null)local.setFirstName(user.getFirstName());
		 if(user.getLastName()!=null)local.setLastName(user.getLastName());
		 if(user.getPassword()!=null)local.setPassword(user.getPassword());
		 if(user.getProfile()!=null)local.setProfile(user.getProfile());
		 if(user.getUserRoles()!=null)local.setUserRoles(user.getUserRoles());
		 
		 
		 userRepo.save(local);
		 
		
		return local;
	}

}

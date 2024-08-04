package com.example.ExamPortalApis.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExamPortalApis.entites.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Long> {
	
	
	public User findByEmail(String email);
	
	public User findByUserID(Long userID);

}

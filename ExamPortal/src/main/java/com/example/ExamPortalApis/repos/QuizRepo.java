package com.example.ExamPortalApis.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExamPortalApis.entites.Category;
import com.example.ExamPortalApis.entites.Quiz;


public interface QuizRepo extends JpaRepository<Quiz, Long> {
	
	public  List<Quiz> findByCategory(Category category);
	
	
	public List<Quiz> findByActive(boolean active);
	
	public List<Quiz> findByCategoryAndActive(Category category, boolean active);

}

package com.example.ExamPortalApis.services;

import java.util.List;
import java.util.Optional;

import com.example.ExamPortalApis.entites.Category;
import com.example.ExamPortalApis.entites.Quiz;

public interface QuizService {
	
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public List<Quiz> getAllQuizzs();
	
	public Quiz getQuiz(Long quizID);
	
	public void deleteQuiz(Long quizID);
	
	
	public List<Quiz> getQuizByCategory(Category category);
	
	
	public List<Quiz> getQuizByActive(boolean active);
	
	public List<Quiz> getActiveQuizOfCategory(Category category,boolean active);

}

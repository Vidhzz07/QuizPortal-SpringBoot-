package com.example.ExamPortalApis.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExamPortalApis.entites.Category;
import com.example.ExamPortalApis.entites.Quiz;
import com.example.ExamPortalApis.repos.QuizRepo;
import com.example.ExamPortalApis.services.QuizService;


@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		
		return quizRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> getAllQuizzs() {
		
		return quizRepo.findAll();
		
	}

	@Override
	public Quiz getQuiz(Long quizID) {
		
		return quizRepo.findById(quizID).get();
	}

	@Override
	public void deleteQuiz(Long quizID) {
		
		quizRepo.deleteById(quizID);
		
		
	}

	@Override
	public List<Quiz> getQuizByCategory(Category category) {

		return quizRepo.findByCategory(category);
	}

	@Override
	public List<Quiz> getQuizByActive(boolean active) {
	
		return quizRepo.findByActive(active);
	}

	@Override
	public List<Quiz> getActiveQuizOfCategory(Category category, boolean active) {
		
		return quizRepo.findByCategoryAndActive(category, active);
	}
	
	
	

}

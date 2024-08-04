package com.example.ExamPortalApis.services.implementations;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExamPortalApis.entites.Question;
import com.example.ExamPortalApis.entites.Quiz;
import com.example.ExamPortalApis.repos.QuestionRepo;
import com.example.ExamPortalApis.services.QuestionService;


@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public Question addQuestion(Question question) {
		
		return questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return questionRepo.save(question);
	}

	@Override
	public List<Question> getAllQuestions() {
		
		return questionRepo.findAll();
				
	}

	@Override
	public Question getQuestion(Long questionID) {
		
		return questionRepo.findById(questionID).get();
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		
		return questionRepo.findByQuiz(quiz);
	}

}

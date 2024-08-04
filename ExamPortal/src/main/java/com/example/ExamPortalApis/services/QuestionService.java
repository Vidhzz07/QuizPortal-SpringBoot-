package com.example.ExamPortalApis.services;

import java.util.List;
import java.util.Set;

import com.example.ExamPortalApis.entites.Question;
import com.example.ExamPortalApis.entites.Quiz;

public interface QuestionService {
	
	
	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public List<Question> getAllQuestions();
	
	public Question getQuestion(Long questionID);
	
	public Set<Question> getQuestionOfQuiz(Quiz quiz);

}

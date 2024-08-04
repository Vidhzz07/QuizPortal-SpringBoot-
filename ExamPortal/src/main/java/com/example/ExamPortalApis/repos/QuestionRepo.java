package com.example.ExamPortalApis.repos;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExamPortalApis.entites.Question;
import com.example.ExamPortalApis.entites.Quiz;

import java.util.List;



public interface QuestionRepo extends JpaRepository<Question, Long> {
	
	
	Set<Question> findByQuiz(Quiz quiz);
	
	
     Question findByQuesID(long quesID);

}

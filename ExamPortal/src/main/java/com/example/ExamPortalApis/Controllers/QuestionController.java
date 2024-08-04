package com.example.ExamPortalApis.Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExamPortalApis.entites.Question;
import com.example.ExamPortalApis.entites.Quiz;
import com.example.ExamPortalApis.services.QuestionService;
import com.example.ExamPortalApis.services.QuizService;
import jakarta.annotation.Resources;



@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	
	@PostMapping("/")
	public ResponseEntity<?> addQuestion(@RequestBody Question question)
	{
		return ResponseEntity.ok(questionService.addQuestion(question));
	}
	
	
	
	@PutMapping("/")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question)
	{
		return ResponseEntity.ok(questionService.updateQuestion(question));
	}
	
	
	@GetMapping("/{questionID")
	public ResponseEntity<?> getQuestion(@PathVariable("questionID") Long questionID)
	{
		return ResponseEntity.ok(questionService.getQuestion(questionID));
	}
	
	
	@GetMapping("/quiz/{quizID}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("quizID") Long quizID)
	{
		Quiz localQuiz = quizService.getQuiz(quizID);
		
		List<Question>  questions = new ArrayList<>(localQuiz.getQuestions());
		
		if(questions.size() > localQuiz.getQuestionCount())
		{
			questions = questions.subList(0, localQuiz.getQuestionCount()+1);
		}
		
		for(Question q: questions)
		{
			q.setAnswer("");
		}
		
		
	  Collections.shuffle(questions);
	  
	  return ResponseEntity.ok(questions);
		
	}
	
	
	@PostMapping("/quiz/evaluate-quiz")
	public ResponseEntity<?> evaluateQuiz(@RequestBody List<Question> questions)
	{
		double marks=0;
		int attempted=0,correct=0;
		
		
		double singleQuestionMarks = 1.00*(questions.get(0).getQuiz().getMaxMarks())/1.00*(questions.get(0).getQuiz().getQuestionCount());
		
		for(Question q:questions)
		{
			Question question = questionService.getQuestion(q.getQuesID());
			
			
			if(q.getAnswer()!=null)
			{
				attempted++;
			}
			
			if(question.getAnswer().equals(q.getAnswer()))
			{
				correct++;
				marks+=singleQuestionMarks;
				
			}
		}
		
		Map<Object, Object>resultMap = Map.of("Marks",marks, "Attempted", attempted, "Correct",correct);
		
		
		
		return ResponseEntity.ok(resultMap);
		
		
	}
	
	
	
	
	

}

package com.example.ExamPortalApis.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExamPortalApis.entites.Category;
import com.example.ExamPortalApis.entites.Quiz;
import com.example.ExamPortalApis.services.QuizService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
	{
		
		return ResponseEntity.ok(quizService.addQuiz(quiz));
	}
	
	
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
	{
		
		return ResponseEntity.ok(quizService.updateQuiz(quiz));
	}
	
	
	@GetMapping("/{quizID}")
	public ResponseEntity<Quiz> getQuiz(@PathVariable("quizID")Long quizID)
	{
		return ResponseEntity.ok(quizService.getQuiz(quizID));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllQuizes()
	{
		return ResponseEntity.ok(quizService.getAllQuizzs());
	}
	
	
	@DeleteMapping("/{quizID}")
	public void deleteQuiz(@PathVariable("quizID") Long quizID)
	{
		quizService.deleteQuiz(quizID);
	}
	
	@GetMapping("/category/{categoryID}")
	public ResponseEntity<?> getQuizByCategory(@PathVariable("categoryID")Long categoryID)
	{
		
		Category localCategory = new Category();
		
		localCategory.setcId(categoryID);
		
		return ResponseEntity.ok(quizService.getQuizByCategory(localCategory));
	}
	
	@GetMapping("/active")
	public ResponseEntity<?> getActiveQuiz() {
		return ResponseEntity.ok(quizService.getQuizByActive(true));
	}
	
	
	@GetMapping("/category/active/{categoryID}")
	public ResponseEntity<?> getActiveQuizByCategory(@PathVariable("categoryID")Long categoryID)
	{
		
		Category localCategory = new Category();
		
		localCategory.setcId(categoryID);
		
		return ResponseEntity.ok(quizService.getActiveQuizOfCategory(localCategory, true));
	}
	

}

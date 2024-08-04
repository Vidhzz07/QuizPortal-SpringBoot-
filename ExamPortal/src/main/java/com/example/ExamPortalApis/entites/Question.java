package com.example.ExamPortalApis.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long quesID;
	
	private String content;
	
	

	private String answer;
	
	
	private String image;
	
	private String option1;
	
	private String option2;
	


	private String option3;
	
	private String option4;
	
	@Transient
	private String givenAnswer;
	
	
	


	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;
	
	
	
	public Question(long quesID, String content, String answer, String image, String option1, String option2,
			String option3, String option4, Quiz quiz) {
		super();
		this.quesID = quesID;
		this.content = content;
		this.answer = answer;
		this.image = image;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.quiz = quiz;
	}
	
	
	public String getGivenAnswer() {
		return givenAnswer;
	}

	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}


	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	

	public long getQuesID() {
		return quesID;
	}

	public void setQuesID(long quesID) {
		this.quesID = quesID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}

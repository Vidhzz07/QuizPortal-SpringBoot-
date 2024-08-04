package com.example.ExamPortalApis.entites;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long quizID;
	
	private boolean isActive =false;
	
	private String title;
	
	


	private String description;
	
	private int maxMarks;
	
	private int questionCount;
	
	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question>questions=new HashSet<>();
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

	
	
	
	
	public Quiz(long quizID, boolean isActive, String title, String description, int maxMarks, int questionCount,
			Set<Question> questions, Category category) {
		super();
		this.quizID = quizID;
		this.isActive = isActive;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.questionCount = questionCount;
		this.questions = questions;
		this.category = category;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public Quiz(long quizID, boolean isActive, String title, String description, int maxMarks, int questionCount,
			Set<Question> questions) {
		super();
		this.quizID = quizID;
		this.isActive = isActive;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.questionCount = questionCount;
		this.questions = questions;
	}
	
	
	

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	
	public long getQuizID() {
		return quizID;
	}

	public void setQuizID(long quizID) {
		this.quizID = quizID;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	

}

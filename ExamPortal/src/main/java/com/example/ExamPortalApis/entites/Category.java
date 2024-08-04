package com.example.ExamPortalApis.entites;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.util.StringBuilderFormattable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cId;
	
	private String title;
	
	private String description;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Quiz>quizs = new HashSet<>();

	public Category(long cId, String title, String description, Set<Quiz> quizs) {
		super();
		this.cId = cId;
		this.title = title;
		this.description = description;
		this.quizs = quizs;
	}

	public Set<Quiz> getQuizs() {
		return quizs;
	}

	public void setQuizs(Set<Quiz> quizs) {
		this.quizs = quizs;
	}

	public long getcId() {
		return cId;
	}

	public void setcId(long cId) {
		this.cId = cId;
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

	public Category(long cId, String title, String description) {
		super();
		this.cId = cId;
		this.title = title;
		this.description = description;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}

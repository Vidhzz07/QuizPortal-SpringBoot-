package com.example.ExamPortalApis.services;

import java.util.List;

import com.example.ExamPortalApis.entites.Category;

public interface CategoryService {
	
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public List<Category> getAllCategories();
	
	public Category getCategory(Long categoryID);
	
	public void deleteCategory(Long categoryId);
	
}

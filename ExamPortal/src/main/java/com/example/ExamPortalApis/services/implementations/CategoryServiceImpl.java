package com.example.ExamPortalApis.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExamPortalApis.entites.Category;
import com.example.ExamPortalApis.repos.CategoryRepo;
import com.example.ExamPortalApis.services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService  {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {
		
		return categoryRepo.save(category);
		
	}

	@Override
	public Category updateCategory(Category category) {
		
		return categoryRepo.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		
		
		return categoryRepo.findAll();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		
		categoryRepo.deleteById(categoryId);
	}

	@Override
	public Category getCategory(Long categoryID) {
		
		return categoryRepo.findById(categoryID).get();
	}
	

}

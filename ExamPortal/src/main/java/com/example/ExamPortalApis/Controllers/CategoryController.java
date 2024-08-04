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
import com.example.ExamPortalApis.repos.CategoryRepo;
import com.example.ExamPortalApis.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)
	{
		 Category categoryLocal = categoryService.addCategory(category);
		 
		 return ResponseEntity.ok(categoryLocal);
	}
	
	@GetMapping("/{categoryID}")
	public ResponseEntity<Category> getCategory(@PathVariable("categoryID") Long categoryID)
	{
		return ResponseEntity.ok(categoryService.getCategory(categoryID));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory()
	{
		return ResponseEntity.ok(categoryService.getAllCategories());
	}
	
	@PutMapping("/")
	public ResponseEntity<Category> updatEntity(@RequestBody Category category)
	{
		
		return ResponseEntity.ok(categoryService.updateCategory(category));
	}
	
	@DeleteMapping("/{categoryID}")
	
	public void deleteEntity(@PathVariable("categoryID")Long categoryID)
	{
		
		categoryService.deleteCategory(categoryID);
	}
	
	
	
	

}

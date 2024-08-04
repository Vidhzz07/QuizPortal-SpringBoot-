package com.example.ExamPortalApis.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExamPortalApis.entites.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}

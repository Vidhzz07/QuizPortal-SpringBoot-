package com.example.ExamPortalApis.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExamPortalApis.entites.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}

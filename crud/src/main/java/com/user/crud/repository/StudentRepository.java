package com.user.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.crud.domain.StudentUser;


public interface StudentRepository extends JpaRepository<StudentUser, Integer> {
	StudentUser findByName(String name);
}
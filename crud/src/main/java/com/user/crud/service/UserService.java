package com.user.crud.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.crud.domain.StudentUser;
import com.user.crud.repository.StudentRepository;

@Service
public class UserService {
	private StudentRepository studentRepository;
	 
	@Autowired
	public UserService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
 
	public StudentUser save(StudentUser studentUser) {
		if (studentUser.getId() != null && studentRepository.exists(studentUser.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
 
		return studentRepository.save(studentUser);
	}
 
	public StudentUser update(StudentUser studentUser) {
		if (studentUser.getId() != null && !studentRepository.exists(studentUser.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}
 
		return studentRepository.save(studentUser);
	}
 
	public List<StudentUser> findAll() {
		return studentRepository.findAll();
	}
 
	public StudentUser findOne(Integer id) {
		return studentRepository.findOne(id);
	}
 
	public void delete(Integer id) {
		studentRepository.delete(id);
	}
}

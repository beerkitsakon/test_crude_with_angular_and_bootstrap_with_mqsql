package com.user.crud.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.crud.domain.StudentUser;
import com.user.crud.service.*;
	@RestController
	@RequestMapping("/api/studentUser")
	public class StudentResource {
	 
		private UserService userService;
	 
		public StudentResource(UserService userService) {
			this.userService = userService;
		}
	 
		@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<StudentUser> getAllStudents() {
			return userService.findAll();
		}
	 
		@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<StudentUser> createstudent(@RequestBody StudentUser studentUser) throws URISyntaxException {
			try {
				StudentUser result = userService.save(studentUser);
				return ResponseEntity.created(new URI("/api/studentUser" + result.getId())).body(result);
			} catch (EntityExistsException e) {
				return new ResponseEntity<StudentUser>(HttpStatus.CONFLICT);
			}
		}
	 
		@RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<StudentUser> updatestudent(  StudentUser studentuser) throws URISyntaxException {
			if (studentuser.getId() == null) {
				return new ResponseEntity<StudentUser>(HttpStatus.NOT_FOUND);
			}
	 
			try {
				StudentUser result = userService.update(studentuser);
	 
				return ResponseEntity.created(new URI("/api/studentUser" + result.getId())).body(result);
			} catch (EntityNotFoundException e) {
				return new ResponseEntity<StudentUser>(HttpStatus.NOT_FOUND);
			}
		}
	 
		@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void> deletestudent(@PathVariable Integer id) {
			userService.delete(id);
	 
			return ResponseEntity.ok().build();
		}
}



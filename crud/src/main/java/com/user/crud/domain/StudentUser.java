package com.user.crud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity

public class StudentUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
 
	@NotNull
	private String name;
 
	@NotNull
	private String studentnumber;
	
 
	public StudentUser() {
	}	
	
	public StudentUser(String name, String studentnumber) {
		super();
		this.name = name;
		this.studentnumber = studentnumber;
	}
	//setter and getter
	public Integer getId() {		
		return id;
	}	
	
	public String getName() {
		return name;
	}
	public String getStudentnumber() {
		return studentnumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStudentnumber(String studentnumber) {
		this.studentnumber = studentnumber;
	}
	
		
	
	
}

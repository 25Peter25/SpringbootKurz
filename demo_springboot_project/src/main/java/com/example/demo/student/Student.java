package com.example.demo.student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	
	@Id
	@SequenceGenerator(name="student_sequence",sequenceName="student_sequence",
						allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
					generator = "student_sequence")
	
	private Long id;
	private String name;
	private String email;
	private LocalDate date_Of_Birth;
	private Integer age;
	
	public Student() {
		super();
	}

	public Student(Long id, String name, String email, LocalDate dateOfBirth, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.date_Of_Birth = dateOfBirth;
		this.age = age;
	}

	public Student(String name, String email, LocalDate dateOfBirth, Integer age) {
		super();
		this.name = name;
		this.email = email;
		this.date_Of_Birth = dateOfBirth;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return date_Of_Birth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.date_Of_Birth = dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dateOfBirth=" + date_Of_Birth + ", age="
				+ age + "]";
	}
	
	
	
	
	
	
	
	

}

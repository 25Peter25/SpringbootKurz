package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@Transient
	private Integer age;
	
	public Student() {
		super();
	}

	public Student(Long id, String name, String email, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.date_Of_Birth = dateOfBirth;
//		this.age = ageCalculator(dateOfBirth);
	}

	public Student(String name, String email, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.email = email;
		this.date_Of_Birth = dateOfBirth;
//		this.age = ageCalculator(dateOfBirth);
	}
	
//	private Integer ageCalculator(LocalDate dateOfBirth) {
//		LocalDate today = LocalDate.now();
//		int yearsDifference = today.getYear()-dateOfBirth.getYear();
//		int daysYearComparison = today.getDayOfYear() - dateOfBirth.getDayOfYear();
//		System.out.println(yearsDifference + " years dif; " + daysYearComparison);
//		return daysYearComparison >= 0 ? yearsDifference : yearsDifference - 1;  
//	}

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
		return Period.between(date_Of_Birth, LocalDate.now()).getYears();
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

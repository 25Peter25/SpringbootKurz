package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	public List<Student> getStudents() {
		return List.of( new Student(1L,"Mariam","mariam.jamal@gmail.com",LocalDate.of(1990, 10, 20), 21));
	}

}

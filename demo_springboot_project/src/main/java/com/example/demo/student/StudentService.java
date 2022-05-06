package com.example.demo.student;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	IStudentRepository studentRepository;

	public StudentService(IStudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() { 
		return studentRepository.findAll();
	}
	
	

}

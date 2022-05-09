package com.example.demo.student;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
	
	IStudentRepository studentRepository;

	public StudentService(IStudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() { 
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail =
				studentRepository.findStudentByEmail(student.getEmail());
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("Email is already registered");
		}
		studentRepository.save(student);
//		System.out.println(student);
	}


	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException("Student with id "+studentId+" does not exists");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long id, String newName, String newEmail) {
		Optional<Student> studentById = studentRepository.findById(id);
		if (studentById.isEmpty()) {
			throw new NullPointerException("Student with id "+id+" is not registered in the database");
		}
		if (newName != null && newName.length() > 0 && !Objects.equals(studentById.get().getName(),newName)) {
			studentById.get().setName(newName);
		}
		if (newEmail != null && newEmail.length() > 0 && !Objects.equals(studentById.get().getEmail(),newEmail)) {
			if (studentRepository.findStudentByEmail(newEmail).isPresent()) {
				throw new IllegalStateException("email already exists");
			}
			studentById.get().setEmail(newEmail);
		}
	}




















}

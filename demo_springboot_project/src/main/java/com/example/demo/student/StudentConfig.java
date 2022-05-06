package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	CommandLineRunner commandLinerRunner(IStudentRepository repository) {
		return args -> {
			Student mariam = new Student("Mariam","mariam.jamal@gmail.com",LocalDate.of(1990, 10, 20), 21);
			Student peter = new Student("Peter","Peter.jamal@gmail.com",LocalDate.of(1995, 10, 20), 16);
			repository.saveAll(List.of(mariam,peter));
		};
	}
}

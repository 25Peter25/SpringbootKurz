package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLinerRunner(IStudentRepository repository) {
		return args -> {
			Student mariam = new Student("Mariam","mariam.jamal@gmail.com",LocalDate.of(2020, 05, 06));
			Student peter = new Student("Peter","Peter.jamal@gmail.com",LocalDate.of(2021, 05, 07));
			Student jana = new Student("Jana","Jana.jamal@gmail.com",LocalDate.of(2021, 05, 8));
			repository.saveAll(List.of(mariam,peter,jana));
		};
	}
}

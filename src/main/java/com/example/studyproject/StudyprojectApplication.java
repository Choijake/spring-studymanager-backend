package com.example.studyproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.example.studyproject.Entity")
@SpringBootApplication
public class StudyprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyprojectApplication.class, args);
	}

}

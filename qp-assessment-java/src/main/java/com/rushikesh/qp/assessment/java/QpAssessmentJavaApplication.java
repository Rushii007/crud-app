package com.rushikesh.qp.assessment.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class QpAssessmentJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(QpAssessmentJavaApplication.class, args);
	}

}

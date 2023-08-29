package com.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@EnableDiscoveryClient
@PropertySource("classpath:query.properties")
@SpringBootApplication
public class StudentprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentprojectApplication.class, args);
	}

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@SpringBootApplication
@EntityScan("com.example.model")
@ComponentScan("com.example.service")
@ComponentScan("com.example.resources")
@EnableJpaRepositories("com.example.repository")
public class DethimauApplication {

	public static void main(String[] args) {
		SpringApplication.run(DethimauApplication.class, args);
	}

}

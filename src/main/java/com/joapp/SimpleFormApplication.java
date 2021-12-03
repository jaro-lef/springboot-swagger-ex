package com.joapp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleFormApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SimpleFormApplication.class, args);
	}
	
	@GetMapping
	public String get() {
		return "root";
	}
	
}

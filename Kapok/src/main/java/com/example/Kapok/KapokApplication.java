package com.example.Kapok;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class KapokApplication {
	
	
	@GetMapping
	public String hello()
	{
		return "Hello world";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KapokApplication.class, args);
	}

}
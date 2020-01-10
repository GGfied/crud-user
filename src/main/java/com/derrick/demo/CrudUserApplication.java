package com.derrick.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CrudUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudUserApplication.class, args);
	}

}

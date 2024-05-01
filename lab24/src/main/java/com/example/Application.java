package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example")
@EntityScan(basePackages = "com.example")
public class Application {

	public static void main(String[] args) throws Throwable{
		SpringApplication.run(Application.class, args);

	}
}

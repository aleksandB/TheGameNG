package com.github.TheGameNG;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.github.TheGameNG.repositories"})
@EnableTransactionManagement
@EntityScan(basePackages = {"com.github.TheGameNG.entities"})
public class TheGameNextGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheGameNextGenerationApplication.class, args);
	}

}

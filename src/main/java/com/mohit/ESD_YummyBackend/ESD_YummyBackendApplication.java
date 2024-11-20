package com.mohit.ESD_YummyBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ESD_YummyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESD_YummyBackendApplication.class, args);
	}
}
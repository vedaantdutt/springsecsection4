package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
//@EnableJpaRepositories("com.repository")
//@EntityScan("com.model")
public class BankBackend {

	public static void main(String[] args) {
		SpringApplication.run(BankBackend.class, args);
	}

}

package com.iscb.RatLab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
public class RatLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatLabApplication.class, args);
	}
}

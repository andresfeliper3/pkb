package com.andresfeliper3.pkb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PkbApplication {

	public static void main(String[] args) {
		SpringApplication.run(PkbApplication.class, args);
	}
}

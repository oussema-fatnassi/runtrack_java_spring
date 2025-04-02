package com.example.Jour3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class Jour3Application {

	public static void main(String[] args) {
		
		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_NAME", dotenv.get("DB_NAME"));

		SpringApplication.run(Jour3Application.class, args);
	}

}

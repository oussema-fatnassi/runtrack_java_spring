package com.example.Jour3;

import com.example.Jour3.model.Person;
import com.example.Jour3.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Jour3Application {

	public static void main(String[] args) {
		SpringApplication.run(Jour3Application.class, args);
	}

	@Bean
	CommandLineRunner runner(PersonRepository personRepository) {
		return args -> {
			Person person = new Person("John Doe", 30);
			personRepository.save(person);

			List<Person> persons = personRepository.findAll();
			System.out.println("All persons: " + persons);

			Optional<Person> found = personRepository.findById(1L);
			found.ifPresent(p -> {
				System.out.println("Found person: " + p);

				p.setAge(31);
				personRepository.save(p);
				System.out.println("Updated person: " + p);

				personRepository.deleteById(p.getId());
				System.out.println("Deleted person with ID " + p.getId());
			});
		};
	}
}

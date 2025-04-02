package com.example.Jour3.controller;

import com.example.Jour3.model.Person;
import com.example.Jour3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String listPersons(Model model) {

        personRepository.save(new Person("John Doe", 30));
        personRepository.save(new Person("Jane Doe", 25));
        personRepository.save(new Person("Alice Smith", 28));
        personRepository.save(new Person("Bob Johnson", 40));

        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "person-list";
    }
}

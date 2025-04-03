package com.example.Jour3.controller;

import com.example.Jour3.model.Person;
import com.example.Jour3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String listPersons(Model model) {
        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "person-list";
    }

    @GetMapping("/edit/{id}")
    public String editPerson(@PathVariable Long id, Model model) {
        Optional<Person> person = personRepository.findById(id);
        person.ifPresent(value -> model.addAttribute("person", value));
        return "edit-person";
    }

    @PostMapping("/update")
    public String updatePerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "add-person";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/"; 
    }
}

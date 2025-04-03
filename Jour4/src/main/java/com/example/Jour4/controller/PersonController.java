package com.example.Jour4.controller;

import com.example.Jour4.model.Person;
import com.example.Jour4.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String listPersons(Model model) {
        List<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "person-list";
    }

    @GetMapping("/edit/{id}")
    public String editPerson(@PathVariable Long id, Model model) {
        Optional<Person> person = personService.findById(id);
        person.ifPresent(value -> model.addAttribute("person", value));
        return "edit-person";
    }

    @PostMapping("/update")
    public String updatePerson(@ModelAttribute Person person) {
        personService.savePerson(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "add-person";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person) {
        personService.savePerson(person);
        return "redirect:/"; 
    }
}

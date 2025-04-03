package com.example.Jour4.service;

import com.example.Jour4.model.Person;
import com.example.Jour4.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

  private final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }

  public Person savePerson(Person person) {
    return personRepository.save(person);
  }

  public void deletePersonById(Long id) {
    personRepository.deleteById(id);
  }

  public Optional<Person> findById(Long id) {
    return personRepository.findById(id);
  }
}
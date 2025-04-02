package com.example.Jour3.repository;

import com.example.Jour3.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);
    List<Person> findByAge(int age);
}

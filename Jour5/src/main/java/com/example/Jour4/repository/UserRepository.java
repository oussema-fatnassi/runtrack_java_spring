package com.example.Jour5.repository;

import com.example.Jour5.model.Person;
import com.example.Jour5.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}

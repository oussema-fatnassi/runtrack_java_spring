package com.example.Jour4.repository;

import com.example.Jour4.model.Person;
import com.example.Jour4.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}

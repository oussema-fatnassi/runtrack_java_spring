package com.example.Jour4.service;

import com.example.Jour4.model.User;
import com.example.Jour4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }
}
package com.koala.backend.service;

import com.koala.backend.dto.request.UserCreationRequest;
import com.koala.backend.entity.User;
import com.koala.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  public User createUser(UserCreationRequest request) {
    User user = new User();
    user.setUsername(request.getUsername());
    user.setPassword(request.getPassword());
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setDob(request.getDob());
    return userRepository.save(user);
  }
  public User getUser(String userId) {
    return userRepository.findById(userId).orElseThrow();
  }
}

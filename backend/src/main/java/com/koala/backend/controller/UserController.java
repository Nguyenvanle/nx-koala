package com.koala.backend.controller;

import com.koala.backend.dto.request.UserCreationRequest;
import com.koala.backend.entity.User;
import com.koala.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping
  User createUser(@RequestBody UserCreationRequest request) {
    return userService.createUser(request);
  }

 @GetMapping("/{userId}")
  User getUser(@PathVariable String userId) {
    return userService.getUser(userId);
 }
}

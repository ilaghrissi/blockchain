package com.example.blockchain.User.controller;

import com.example.blockchain.User.User;
import com.example.blockchain.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/create/{username}")
  public ResponseEntity<String> createUser(@PathVariable("username") String username){
    User result = userService.createUser(username);
    return new ResponseEntity<>(result.getUserId(), HttpStatus.CREATED);
  }

}

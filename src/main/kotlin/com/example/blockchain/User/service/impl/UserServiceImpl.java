package com.example.blockchain.User.service.impl;

import com.example.blockchain.User.User;
import com.example.blockchain.User.service.UserService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private Map<String, User> users;

  public UserServiceImpl(){
    this.users = new HashMap<>();
  }
  @Override
  public User createUser(String username) {
    String userId = generateUserId();
    User user = new User(userId, username);
    users.put(userId,user);
    return user;
  }

  @Override
  public Optional<User> getUserById(String userId) {
    User user = users.get(userId);
    if(user !=null){
      return Optional.of(user);
    }
    return Optional.empty();
  }


  private String generateUserId() {
    return UUID.randomUUID().toString();
  }
}

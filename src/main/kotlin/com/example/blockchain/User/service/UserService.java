package com.example.blockchain.User.service;

import com.example.blockchain.User.User;
import java.util.Optional;

public interface UserService {

  /**
   * create new user
   * @param username
   * @return
   */
  User createUser(String username);

  /**
   * get a user by id
   * @param userId
   * @return
   */
  Optional<User> getUserById(String userId);

}

package com.example.blockchain.User;

import com.example.blockchain.domain.Address;
import com.example.blockchain.domain.Wallet;
import java.util.HashMap;
import java.util.Map;

public class User {

  private String userId;
  private String username;

  private String email;

  private String password;

  private Address address;

  private boolean enabled;

  private Map<String, Wallet> wallets;

  public User(String userId, String username){
    this.userId = userId;
    this.username = username;
    this.wallets = new HashMap<>();
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Map<String, Wallet> getWallets() {
    return wallets;
  }

  public void setWallets(Map<String, Wallet> wallets) {
    this.wallets = wallets;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}

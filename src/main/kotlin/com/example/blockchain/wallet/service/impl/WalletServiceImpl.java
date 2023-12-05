package com.example.blockchain.wallet.service.impl;

import com.example.blockchain.User.User;
import com.example.blockchain.User.service.UserService;
import com.example.blockchain.domain.Transaction;
import com.example.blockchain.domain.Wallet;
import com.example.blockchain.wallet.service.WalletService;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

  Logger logger = LoggerFactory.getLogger(WalletServiceImpl.class);


  @Autowired
  private UserService userService;

  @Override
  public Optional<Wallet> createWalletForUser(String userId) {
    Optional<User> user = userService.getUserById(userId);
    if(user.isPresent()) {
     Map<String, Wallet> userWallets = user.get().getWallets();
     Wallet wallet = new Wallet();
     wallet.setWalletId(generateWalletId());
     wallet.generateKeyPair();

     userWallets.put(wallet.getWalletId(), wallet);
     for (Map.Entry<String,Wallet> w: userWallets.entrySet()){
       logger.info("key {} and value {}",w.getKey(),w.getValue());
     }
     return Optional.of(wallet);
   }
    return Optional.empty();
  }

  @Override
  public List<String> getUserWallets(String userId) {
    Optional<User> result = userService.getUserById(userId);
    return result.map(user -> user.getWallets().values().stream().map(Wallet::getWalletId).toList())
        .orElse(Collections.emptyList());
  }

  @Override
  public BigDecimal getBalance(String walletAddress) {
    return null;
  }

  @Override
  public Transaction sendTransaction(Wallet from, String to, BigDecimal amount) {
    return null;
  }

  @Override
  public String generateAddress() {
    return null;
  }

  private String generateWalletId() {
    return UUID.randomUUID().toString();
  }
}

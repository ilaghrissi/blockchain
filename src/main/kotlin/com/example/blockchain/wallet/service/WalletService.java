package com.example.blockchain.wallet.service;


import com.example.blockchain.domain.Transaction;
import com.example.blockchain.domain.Wallet;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface WalletService {

  /**
   * create a wallet for a user
   * @param userId
   */
  Optional<Wallet> createWalletForUser(String userId);

  /**
   * get list of wallets of selected user
   * @param userId
   * @return
   */
  List<String> getUserWallets(String userId);

  BigDecimal getBalance(String walletAddress);

  Transaction sendTransaction(Wallet from, String to, BigDecimal amount);

  String generateAddress();

}

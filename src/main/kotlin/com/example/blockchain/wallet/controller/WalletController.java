package com.example.blockchain.wallet.controller;

import com.example.blockchain.domain.Wallet;
import com.example.blockchain.wallet.service.WalletService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {


  @Autowired
  private WalletService walletService;

  @PostMapping("/create/{userId}")
  public ResponseEntity<String> createWallet(@PathVariable("userId") String userId){
    Optional<Wallet> result = walletService.createWalletForUser(userId);
    return result.map(wallet -> new ResponseEntity<>(wallet.getWalletId(), HttpStatus.CREATED))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @GetMapping("/user/wallets/{userId}")
  public ResponseEntity<List<String>> getUserWallets(@PathVariable("userId") String userId){
    List<String> result = walletService.getUserWallets(userId);
    return new ResponseEntity<>(result,HttpStatus.OK);
  }

  @GetMapping("/public-key")
  public String getPublicKey(){
    Wallet wallet = new Wallet();

    return StringTemplate.STR."\{wallet.getPublicKey()}";
  }

}

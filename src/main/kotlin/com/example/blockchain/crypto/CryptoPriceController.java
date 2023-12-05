package com.example.blockchain.crypto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoPriceController {

  @Autowired
  private CryptoPriceService cryptoPriceService;

  @GetMapping("/crypto/{cryptoSymbol}/price/{currency}")
  public String getCryptoPrice(@PathVariable String cryptoSymbol, @PathVariable String currency) {
    return cryptoPriceService.getCryptoPrice(cryptoSymbol, currency);
  }
}

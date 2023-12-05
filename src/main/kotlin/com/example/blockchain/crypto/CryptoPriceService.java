package com.example.blockchain.crypto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoPriceService {

  @Value("${coingecko.api.url}")
  private String coingeckoApiUrl;

  private final RestTemplate restTemplate;

  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

  public CryptoPriceService() {
    this.restTemplate = restTemplate();
  }

  public String getCryptoPrice(String cryptoSymbol, String currency) {
    String url = coingeckoApiUrl + "/simple/price?ids=" + cryptoSymbol + "&vs_currencies=" + currency;

    return restTemplate.getForObject(url, String.class);
  }
}

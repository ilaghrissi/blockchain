package com.example.blockchain.core.controller;


import com.example.blockchain.core.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ethereum")
public class EthereumController {

  private final BlockchainService blockchainService;

  @Autowired
  public EthereumController(BlockchainService blockchainService) {
    this.blockchainService = blockchainService;
  }

  @GetMapping("/client/version")
  public String getClientVersion() {
    return blockchainService.getClientVersion();
  }

}

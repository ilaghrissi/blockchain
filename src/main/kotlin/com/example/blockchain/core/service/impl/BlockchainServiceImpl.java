package com.example.blockchain.core.service.impl;

import com.example.blockchain.core.service.BlockchainService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

@Service
public class BlockchainServiceImpl implements BlockchainService {

  private final Web3j web3j;
  @Autowired
  public BlockchainServiceImpl(Web3j web3j) {
    this.web3j = web3j;
  }
  @Override
  public String getClientVersion() {
    try {
      Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
      return web3ClientVersion.getWeb3ClientVersion();
    } catch (IOException e) {
      e.printStackTrace();
      return "Error connecting to Ethereum network.";
    }
  }
}

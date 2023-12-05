package com.example.blockchain.domain;

import java.util.List;
import lombok.Data;

@Data
public class Block {

  private int blockId;

  private String previousHash;

  private List<Transaction> transactions;

}

package com.example.blockchain.domain;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class Transaction {

  private UUID transactionId;

  private String sender;

  private String receiver;

  private BigDecimal amount;

  private Status status;
}

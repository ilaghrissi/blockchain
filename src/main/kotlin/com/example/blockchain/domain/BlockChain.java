package com.example.blockchain.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class BlockChain {

  private List<Block> blockchain;

  public BlockChain (){
    this.blockchain = new ArrayList<>();
    this.blockchain.add(generateGenesisBlock());
  }

  private Block generateGenesisBlock() {
    return new Block();
  }

  private void addBlock(Block newBlock){
    this.blockchain.add(newBlock);
  }
}

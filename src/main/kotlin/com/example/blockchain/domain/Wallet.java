package com.example.blockchain.domain;

import java.math.BigDecimal;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import java.security.*;

public class Wallet {

  private String walletId;

  private PrivateKey privateKey;

  private PublicKey publicKey;

  private BigDecimal balance;

  public Wallet(){
    Security.addProvider(new BouncyCastleProvider());
    generateKeyPair();
  }

  public void generateKeyPair() {

    try {
      ECNamedCurveParameterSpec params = ECNamedCurveTable.getParameterSpec("secp256k1");
      KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC", "BC");
      keyGen.initialize(params, new SecureRandom());

      KeyPair keyPair = keyGen.generateKeyPair();

       privateKey = keyPair.getPrivate();
       publicKey = keyPair.getPublic();

    } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | NoSuchProviderException e) {
      throw new RuntimeException(e);
    }
  }

  public String getWalletId() {
    return walletId;
  }

  public void setWalletId(String walletId) {
    this.walletId = walletId;
  }

  public PrivateKey getPrivateKey() {
    return privateKey;
  }

  public void setPrivateKey(PrivateKey privateKey) {
    this.privateKey = privateKey;
  }

  public PublicKey getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(PublicKey publicKey) {
    this.publicKey = publicKey;
  }

  @Override
  public String toString() {
    return "Wallet{" +
        "walletId='" + walletId + '\'' +
        ", privateKey=" + privateKey +
        ", publicKey=" + publicKey +
        '}';
  }
}

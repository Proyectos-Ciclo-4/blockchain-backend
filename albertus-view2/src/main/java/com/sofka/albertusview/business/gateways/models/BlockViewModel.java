package com.sofka.albertusview.business.gateways.models;

import java.time.Instant;

public class BlockViewModel {

  private String hash;
  private Instant timeStamp;
  private Integer nonce;
  private Boolean hasOverCharge;
  private String previousHash;

  public BlockViewModel(String hash, Instant timeStamp, Integer nonce, Boolean hasOverCharge,
      String previousHash) {
    this.hash = hash;
    this.timeStamp = timeStamp;
    this.nonce = nonce;
    this.hasOverCharge = hasOverCharge;
    this.previousHash = previousHash;
  }

  public BlockViewModel() {
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public Instant getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Instant timeStamp) {
    this.timeStamp = timeStamp;
  }

  public Integer getNonce() {
    return nonce;
  }

  public void setNonce(Integer nonce) {
    this.nonce = nonce;
  }

  public Boolean getHasOverCharge() {
    return hasOverCharge;
  }

  public void setHasOverCharge(Boolean hasOverCharge) {
    this.hasOverCharge = hasOverCharge;
  }

  public String getPreviousHash() {
    return previousHash;
  }

  public void setPreviousHash(String previousHash) {
    this.previousHash = previousHash;
  }
}

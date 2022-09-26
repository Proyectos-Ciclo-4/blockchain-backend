package com.sofka.albertus.application.bus.models;

import java.time.Instant;
import java.util.Map;

public class BlockViewModel {

  private String applicationId;

  private Map<String, Object> data;
  private String hash;
  private Instant timeStamp;
  private Integer nonce;
  private Boolean hasOverCharge;
  private String previousHash;

  public BlockViewModel(String applicationId, Map<String, Object> data, String hash, Instant timeStamp, Integer nonce, Boolean hasOverCharge,
                        String previousHash) {
    this.applicationId = applicationId;
    this.data = data;
    this.hash = hash;
    this.timeStamp = timeStamp;
    this.nonce = nonce;
    this.hasOverCharge = hasOverCharge;
    this.previousHash = previousHash;
  }

  public Map<String, Object> getData() {
    return data;
  }

  public void setData(Map<String, Object> data) {
    this.data = data;
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

  public String getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(String applicationId) {
    this.applicationId = applicationId;
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

package com.sofka.albertusview.business.gateways.models;

import com.sofka.albertusview.domain.values.CreationDate;
import com.sofka.albertusview.domain.values.ModificationDate;

import java.time.Instant;

public class ApplicationViewModel {

  private String applicationID;
  private String nameApplication;
  private String description;
  private Boolean isActive;
  private String userId;

  private Instant creationDate;

  private Instant modificationDate;

  public ApplicationViewModel(String applicationID, String nameApplication, String description, Boolean isActive, String userId,Instant creationDate,Instant modificationDate) {
    this.applicationID = applicationID;
    this.nameApplication = nameApplication;
    this.description = description;
    this.isActive = isActive;
    this.userId = userId;
    this.creationDate = creationDate;
    this.modificationDate = modificationDate;
  }

  public String getNameApplication() {
    return nameApplication;
  }

  public void setNameApplication(String nameApplication) {
    this.nameApplication = nameApplication;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getApplicationID() {
    return applicationID;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Instant getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Instant creationDate) {
    this.creationDate = creationDate;
  }

  public Instant getModificationDate() {
    return modificationDate;
  }

  public void setModificationDate(Instant modificationDate) {
    this.modificationDate = modificationDate;
  }
}

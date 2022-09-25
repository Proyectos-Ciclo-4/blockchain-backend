package com.sofka.albertusview.business.gateways.models;

import com.sofka.albertusview.domain.values.UserId;

public class ApplicationViewModel {

  private String applicationID;
  private String nameApplication;
  private String description;
  private Boolean isActive;
  private String userId;

  public ApplicationViewModel(String nameApplication, String description, Boolean isActive, String userId) {
    this.nameApplication = nameApplication;
    this.description = description;
    this.isActive = isActive;
    this.userId = userId;
  }

  public ApplicationViewModel(String applicationID,Boolean isActive) {
    this.applicationID = applicationID;
    this.isActive = isActive;
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
}

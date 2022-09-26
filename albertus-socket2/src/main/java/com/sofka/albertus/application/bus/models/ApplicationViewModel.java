package com.sofka.albertus.application.bus.models;

public class ApplicationViewModel {

  private String applicationID;
  private String nameApplication;
  private String description;
  private Boolean isActive;
  private String userId;

  public ApplicationViewModel(String applicationID, String nameApplication, String description, Boolean isActive, String userId) {
    this.applicationID = applicationID;
    this.nameApplication = nameApplication;
    this.description = description;
    this.isActive = isActive;
    this.userId = userId;
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

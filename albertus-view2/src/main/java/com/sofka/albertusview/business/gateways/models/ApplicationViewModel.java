package com.sofka.albertusview.business.gateways.models;

import com.sofka.albertusview.domain.values.UserId;

public class ApplicationViewModel {

  private String nameApolication;
  private String description;
  private Boolean isActive;
  private UserId userId;

  public ApplicationViewModel(String nameApolication, String description, Boolean isActive,
      UserId userId) {
    this.nameApolication = nameApolication;
    this.description = description;
    this.isActive = isActive;
    this.userId = userId;
  }

  public String getNameApolication() {
    return nameApolication;
  }

  public void setNameApolication(String nameApolication) {
    this.nameApolication = nameApolication;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public UserId getUserId() {
    return userId;
  }

  public void setUserId(UserId userId) {
    this.userId = userId;
  }
}

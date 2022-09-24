package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ApplicationRegistered extends DomainEvent {

    private String nameApplication;

    private String description;

    private Boolean isActive;

    private String userId;

    public ApplicationRegistered(String nameApplication, String description, Boolean isActive, String userId) {
        super("sofka.albertus.domain.ApplicationRegistered");
        this.nameApplication = nameApplication;
        this.description = description;
        this.isActive = isActive;
        this.userId = userId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getUserId() {
        return userId;
    }

    public String getNameApplication() {
        return nameApplication;
    }

    public String getDescription() {
        return description;
    }
}

package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.time.Instant;

public class ApplicationRegistered extends DomainEvent {

    private String applicationId;
    private String nameApplication;

    private String description;

    private Boolean isActive;

    private String userId;

    private Instant creationDate;

    private Instant modificationDate;


    public ApplicationRegistered(String applicationId,
                                 String nameApplication,
                                 String description,
                                 Boolean isActive,
                                 String userId,
                                 Instant creationDate,
                                 Instant modificationDate) {
        super("sofka.albertus.domain.ApplicationRegistered");
        this.applicationId = applicationId;
        this.nameApplication = nameApplication;
        this.description = description;
        this.isActive = isActive;
        this.userId = userId;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public Instant getModificationDate() {
        return modificationDate;
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

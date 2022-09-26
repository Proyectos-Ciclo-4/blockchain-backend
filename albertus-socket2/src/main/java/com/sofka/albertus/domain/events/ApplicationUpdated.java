package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ApplicationUpdated extends DomainEvent {

    private String applicationID;

    private String nameApplication;

    private String description;

    public ApplicationUpdated(String applicationID, String nameApplication, String description) {
        super("sofka.albertus.domain.ApplicationUpdated");
        this.applicationID = applicationID;
        this.nameApplication = nameApplication;
        this.description = description;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getNameApplication() {
        return nameApplication;
    }

    public String getDescription() {
        return description;
    }
}

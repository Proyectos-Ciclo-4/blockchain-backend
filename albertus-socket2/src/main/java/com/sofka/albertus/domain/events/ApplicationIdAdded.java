package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ApplicationIdAdded extends DomainEvent {

    private String applicationID;

    private String userID;

    public ApplicationIdAdded(String applicationID, String userID) {
        super("sofka.albertus.domain.ApplicationIdAdded");
        this.applicationID = applicationID;
        this.userID = userID;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getUserID() {
        return userID;
    }
}

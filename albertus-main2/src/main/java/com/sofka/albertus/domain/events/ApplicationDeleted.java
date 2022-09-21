package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ApplicationDeleted extends DomainEvent {

    private String applicationID;

    public ApplicationDeleted(String applicationID) {
        super("sofka.albertus.domain.ApplicationDeleted");
        this.applicationID = applicationID;
    }

    public String getApplicationID() {
        return applicationID;
    }
}

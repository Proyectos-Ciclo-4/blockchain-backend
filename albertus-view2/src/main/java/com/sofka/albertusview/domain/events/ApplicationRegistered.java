package com.sofka.albertusview.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ApplicationRegistered extends DomainEvent {

    private String nameApplication;

    private String description;

    public ApplicationRegistered(String nameApplication, String description) {
        super("sofka.albertus.domain.ApplicationRegistered");
        this.nameApplication = nameApplication;
        this.description = description;
    }

    public String getNameApplication() {
        return nameApplication;
    }

    public String getDescription() {
        return description;
    }
}

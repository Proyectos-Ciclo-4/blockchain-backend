package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class BlockCreated extends DomainEvent {


    private String applicationID;
    private String data;

    public BlockCreated(String applicationID, String data) {
        super("sofka.albertus.domain.BlockCreated");
        this.applicationID = applicationID;
        this.data = data;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getData() {
        return data;
    }
}

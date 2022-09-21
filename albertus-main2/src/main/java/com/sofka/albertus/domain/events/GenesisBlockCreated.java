package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class GenesisBlockCreated extends DomainEvent {

    private String data;

    public GenesisBlockCreated() {
        super("sofka.albertus.domain.GenesisBlockCreated");
    }

    public GenesisBlockCreated(String data) {
        super("sofka.albertus.domain.GenesisBlockCreated");
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

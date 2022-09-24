package com.sofka.albertusview.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.Map;

public class GenesisBlockCreated extends DomainEvent {

    private Map<String, Object> data;

    public GenesisBlockCreated() {
        super("sofka.albertus.domain.GenesisBlockCreated");
    }

    public GenesisBlockCreated(Map<String, Object> data) {
        super("sofka.albertus.domain.GenesisBlockCreated");
        this.data = data;
    }

    public Map<String, Object> getData() {
        return data;
    }
}

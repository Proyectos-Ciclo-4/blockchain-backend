package com.sofka.albertus.application.helpers;

import co.com.sofka.domain.generic.DomainEvent;

import java.io.Serializable;
import java.util.UUID;

public class Prueba extends DomainEvent implements Serializable {

    public final String hash;

    public Prueba(String type, String aggregateRootId, String aggregateParentId, UUID uuid, String hash) {
        super(type, aggregateRootId, aggregateParentId, uuid);
        this.hash = hash;
    }

    public Prueba(String type, String aggregateRootId, UUID uuid, String hash) {
        super(type, aggregateRootId, uuid);
        this.hash = hash;
    }

    public Prueba(String type, UUID uuid, String hash) {
        super(type, uuid);
        this.hash = hash;
    }

    public Prueba(String type, String hash) {
        super(type);
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

}

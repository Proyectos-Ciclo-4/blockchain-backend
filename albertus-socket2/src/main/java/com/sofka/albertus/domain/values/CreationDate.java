package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.Instant;

public class CreationDate implements ValueObject<Instant> {

    private final Instant creationDate;

    public CreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public Instant value() {
        return null;
    }

    public Instant getCreationDate() {
        return creationDate;
    }
}

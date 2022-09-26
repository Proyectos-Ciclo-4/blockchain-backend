package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.Instant;

public class ModificationDate implements ValueObject<Instant> {

    private final Instant modificationDate;

    public ModificationDate(Instant modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public Instant value() {
        return null;
    }

    public Instant getModificationDate() {
        return modificationDate;
    }
}

package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Description implements ValueObject<String> {
    private final String description;

    public Description(String description) {
        this.description = description;

    }

    @Override
    public String value() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description description = (Description) o;
        return Objects.equals(description, description.description);
    }
    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}

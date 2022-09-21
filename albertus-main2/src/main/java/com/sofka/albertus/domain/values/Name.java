package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {
    private final String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(name, name.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FullName implements ValueObject<String> {
    private final String fullName;

    public FullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String value() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(fullName, fullName.fullName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}

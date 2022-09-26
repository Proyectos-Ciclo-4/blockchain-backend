package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IsActive implements ValueObject<Boolean> {
    private final Boolean isActive;

    public IsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public Boolean value() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsActive isActive = (IsActive) o;
        return Objects.equals(isActive, isActive.isActive);
    }
    @Override
    public int hashCode() {
        return Objects.hash(isActive);
    }
}

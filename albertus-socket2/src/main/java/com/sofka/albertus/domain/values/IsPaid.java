package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IsPaid implements ValueObject<String> {
    private final String isPaid;

    public IsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public String value() {
        return isPaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsPaid isPaid = (IsPaid) o;
        return Objects.equals(isPaid, isPaid.isPaid);
    }
    @Override
    public int hashCode() {
        return Objects.hash(isPaid);
    }
}

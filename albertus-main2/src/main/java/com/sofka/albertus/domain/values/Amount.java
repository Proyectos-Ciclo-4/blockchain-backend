package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Amount implements ValueObject<String> {
    private final String amount;

    public Amount(String amount) {
        this.amount = amount;
    }

    @Override
    public String value() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Objects.equals(amount, amount.amount);
    }
    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}

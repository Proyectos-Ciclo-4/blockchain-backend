package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Discount implements ValueObject<String> {

    private final String discount;

    public Discount(String discount) {
        this.discount = discount;
    }

    @Override
    public String value() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return Objects.equals(discount, discount.discount);
    }
    @Override
    public int hashCode() {
        return Objects.hash(discount);
    }
}

package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {
    private final String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public String value() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(email, email.email);
    }
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

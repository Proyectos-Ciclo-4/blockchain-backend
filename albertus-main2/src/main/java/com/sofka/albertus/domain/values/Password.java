package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Password implements ValueObject<String> {
    private final String password;

    public Password(String password) {
        this.password = password;
    }

    @Override
    public String value() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return Objects.equals(password, password.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}

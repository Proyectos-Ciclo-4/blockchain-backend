package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class UserId extends Identity implements ValueObject<String> {


    public UserId(String id) {
        super(id);
    }

    public UserId() {
    }

    public static UserId of(String id) {
        return new UserId(id);
    }
}

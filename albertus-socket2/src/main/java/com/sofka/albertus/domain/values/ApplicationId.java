package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.Identity;

public class ApplicationId extends Identity {

    private ApplicationId(String id) {
        super(id);
    }

    private ApplicationId() {

    }

    public static ApplicationId of(String id){
        return new ApplicationId(id);
    }
}

package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class InvoiceId extends Identity implements ValueObject<String> {
    public InvoiceId(String id) {
        super(id);
    }

    public InvoiceId() {
    }

    public static InvoiceId of(String id) {
        return new InvoiceId(id);
    }
}

package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InvoiceDate implements ValueObject<String> {
    private final String invoiceDate;

    public InvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String value() {
        return invoiceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDate invoiceDate = (InvoiceDate) o;
        return Objects.equals(invoiceDate, invoiceDate.invoiceDate);
    }
    @Override
    public int hashCode() {
        return Objects.hash(invoiceDate);
    }
}

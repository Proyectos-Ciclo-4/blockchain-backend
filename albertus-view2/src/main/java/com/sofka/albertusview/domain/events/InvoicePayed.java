package com.sofka.albertusview.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class InvoicePayed extends DomainEvent {

    private String invoiceID;

    public InvoicePayed(String invoiceID) {
        super("sofka.albertus.domain.InvoicePayed");
        this.invoiceID = invoiceID;
    }

    public String getInvoiceID() {
        return invoiceID;
    }
}

package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class InvoiceCalculated  extends DomainEvent {

    private String invoiceId;


    public InvoiceCalculated(String invoiceId) {
        super("sofka.albertus.domain.InvoiceCalculated");
        this.invoiceId = invoiceId;
    }


    public String getInvoiceId() {
        return invoiceId;
    }


}

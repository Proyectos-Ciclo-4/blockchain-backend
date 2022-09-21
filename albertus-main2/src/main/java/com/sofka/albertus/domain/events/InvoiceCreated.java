package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.time.Instant;

public class InvoiceCreated extends DomainEvent {

    private String applicationID;
    private Instant invoiceDate;
    private String billingMonth;
    private Boolean isPaid;


    public InvoiceCreated(String applicationID, String billingMonth) {
        super("sofka.albertus.domain.InvoiceCreated");
        this.applicationID = applicationID;
        this.billingMonth = billingMonth;
        this.invoiceDate = Instant.now();
        this.isPaid = false;
    }


    public String getApplicationID() {
        return applicationID;
    }

    public String getBillingMonth() {
        return billingMonth;
    }

    public Instant getInvoiceDate() {
        return invoiceDate;
    }

    public Boolean getPaid() {
        return isPaid;
    }
}

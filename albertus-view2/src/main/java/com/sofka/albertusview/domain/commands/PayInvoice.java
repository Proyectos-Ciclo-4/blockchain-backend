package com.sofka.albertusview.domain.commands;

import co.com.sofka.domain.generic.Command;

public class PayInvoice extends Command {

    private String invoiceID;

    public PayInvoice(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public PayInvoice() {
    }

    public String getInvoiceID() {
        return invoiceID;
    }
}

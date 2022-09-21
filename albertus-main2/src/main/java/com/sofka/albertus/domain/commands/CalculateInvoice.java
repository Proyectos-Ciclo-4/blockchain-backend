package com.sofka.albertus.domain.commands;

import co.com.sofka.domain.generic.Command;

public class CalculateInvoice extends Command {

    private String invoiceId;
    private String applicationID;
    private String billingMonth;

    public CalculateInvoice(String applicationID, String billingMonth, String invoiceId) {
        this.applicationID = applicationID;
        this.billingMonth = billingMonth;
        this.invoiceId = invoiceId;
    }

    public CalculateInvoice() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getBillingMonth() {
        return billingMonth;
    }

    public String getInvoiceId() {
        return invoiceId;
    }
}

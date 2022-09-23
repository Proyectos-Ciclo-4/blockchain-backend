package com.sofka.albertusview.domain.commands;

import co.com.sofka.domain.generic.Command;

public class CreateInvoice extends Command {

    private String applicationID;
    private String billingMonth;

    public CreateInvoice(String applicationID, String billingMonth) {
        this.applicationID = applicationID;
        this.billingMonth = billingMonth;
    }

    public CreateInvoice() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getBillingMonth() {
        return billingMonth;
    }
}

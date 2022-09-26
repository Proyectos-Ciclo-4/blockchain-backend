package com.sofka.albertus.domain.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.albertus.domain.values.*;

public class Invoice extends Entity<InvoiceId> {
    private InvoiceDate invoiceDate;
    private Amount amount;
    private IsPaid isPaid;
    private Discount discount;
    private ApplicationId applicationId;


    public Invoice(InvoiceId entityId,
                   InvoiceDate invoiceDate,
                   Amount amount,
                   IsPaid isPaid,
                   Discount discount,
                   ApplicationId applicationId)
    {
        super(entityId);
        this.invoiceDate = invoiceDate;
        this.amount = amount;
        this.isPaid = isPaid;
        this.discount = discount;
        this.applicationId = applicationId;
    }

    public InvoiceDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(InvoiceDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public IsPaid getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(IsPaid isPaid) {
        this.isPaid = isPaid;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public ApplicationId getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(ApplicationId applicationId) {
        this.applicationId = applicationId;
    }
}

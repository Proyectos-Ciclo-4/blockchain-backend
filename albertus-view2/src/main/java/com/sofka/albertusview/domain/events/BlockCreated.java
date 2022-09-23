package com.sofka.albertusview.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.time.Instant;

public class BlockCreated extends DomainEvent {


    private String applicationID;
    private String data;

    private String hash;
    private Instant timeStamp;
    private Integer nonce;
    private Boolean hasOverCharge;
    private String previousHash;

    public BlockCreated(String applicationID, String data, String hash, Instant timeStamp, Integer nonce, Boolean hasOverCharge, String previousHash) {
        super("sofka.albertus.domain.BlockCreated");
        this.applicationID = applicationID;
        this.data = data;
        this.hash = hash;
        this.timeStamp = timeStamp;
        this.nonce = nonce;
        this.hasOverCharge = hasOverCharge;
        this.previousHash = previousHash;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getData() {
        return data;
    }

    public String getHash() {
        return hash;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public Integer getNonce() {
        return nonce;
    }

    public Boolean getHasOverCharge() {
        return hasOverCharge;
    }

    public String getPreviusHash() {
        return previousHash;
    }
}

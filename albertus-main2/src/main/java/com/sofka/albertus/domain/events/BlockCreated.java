package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.time.Instant;
import java.util.Map;

public class BlockCreated extends DomainEvent {

    private String applicationID;
    private Map<String, Object> data;

    private String hash;
    private Instant timeStamp;
    private Integer nonce;
    private Boolean hasOverCharge;
    private String previousHash;

    public BlockCreated(String applicationID, Map<String, Object>  data, String hash, Instant timeStamp, Integer nonce, Boolean hasOverCharge, String previousHash) {
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

    public Map<String, Object>  getData() {
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

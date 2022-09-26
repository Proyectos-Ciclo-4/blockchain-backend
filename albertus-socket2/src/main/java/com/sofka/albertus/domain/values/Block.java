package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.Instant;
import java.util.Set;

public class Block implements ValueObject<Block.Props> {

    private final String hash;

    private final String previousHash;

    private final Object data;

    private final Instant TimeStamp;

    private final Integer nonce;

    private final Boolean hasOverCharge;

    private final String applicationID;

    public Block(String hash, String previousHash, Object data, Instant timeStamp, Integer nonce, Boolean hasOverCharge, String applicationID) {
        this.hash = hash;
        this.previousHash = previousHash;
        this.data = data;
        TimeStamp = timeStamp;
        this.nonce = nonce;
        this.hasOverCharge = hasOverCharge;
        this.applicationID = applicationID;
    }

    @Override
    public Props value() {
        return new Props() {

            @Override
            public String hash() {
                return hash;
            }

            @Override
            public String previousHash() {
                return previousHash;
            }

            @Override
            public Object data() {
                return data;
            }

            @Override
            public Instant TimeStamp() {
                return TimeStamp;
            }

            @Override
            public Integer nonce() {
                return nonce;
            }

            @Override
            public Boolean hasOverCharge() {
                return hasOverCharge;
            }

            @Override
            public String applicationID() {
                return applicationID;
            }
        };
    }

    public interface Props {
        String hash();

        String previousHash();

        Object data();

        Instant TimeStamp();

        Integer nonce();

        Boolean hasOverCharge();

        String applicationID();
    }
}

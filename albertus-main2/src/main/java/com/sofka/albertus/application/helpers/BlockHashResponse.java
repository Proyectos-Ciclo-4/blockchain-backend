package com.sofka.albertus.application.helpers;

import com.sofka.albertus.domain.events.BlockCreated;
import org.springframework.stereotype.Component;


public class BlockHashResponse {
    private final String hash;


    public BlockHashResponse(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public static  BlockHashResponse from(BlockCreated blockCreated){
        return new BlockHashResponse(blockCreated.getHash());
    }
}

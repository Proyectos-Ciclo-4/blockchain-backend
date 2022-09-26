package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.Identity;

public class BlockChainId extends Identity {

    private BlockChainId(String id) {
        super(id);
    }

    private BlockChainId() {

    }

    public static BlockChainId of(String id){
        return new BlockChainId(id);
    }

}

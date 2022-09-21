package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.domain.BlockChain;
import com.sofka.albertus.domain.values.BlockChainId;

public class BlockChainCreated extends DomainEvent {

    private String blockChainId;
    private String  blockChainName;

    public BlockChainCreated(String blockChainId,String blockChainName) {
        super("sofka.albertus.domain.BlockChainCreated");
        this.blockChainId = blockChainId;
        this.blockChainName = blockChainName;
    }
    public BlockChainCreated() {
        super("sofka.albertus.domain.BlockChainCreated");
    }

    public String getBlockChainId() {
        return blockChainId;
    }

    public String getBlockChainName() {
        return blockChainName;
    }
}

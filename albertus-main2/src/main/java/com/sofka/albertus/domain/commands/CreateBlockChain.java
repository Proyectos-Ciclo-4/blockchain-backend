package com.sofka.albertus.domain.commands;

import co.com.sofka.domain.generic.Command;

public class CreateBlockChain extends Command {

    private  String BlockChainId;
    private String blockChainName;

    public CreateBlockChain(String blockChainId,String blockChainName) {
        BlockChainId = blockChainId;
        this.blockChainName = blockChainName;
    }

    public CreateBlockChain() {

    }

    public String getBlockChainId() {
        return BlockChainId;
    }

    public String getBlockChainName() {
        return blockChainName;
    }
}

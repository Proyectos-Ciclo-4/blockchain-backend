package com.sofka.albertusview.domain.commands;

import co.com.sofka.domain.generic.Command;

public class CreateBlockChain extends Command {

    private  String blockChainId;
    private String blockChainName;

    public CreateBlockChain(String blockChainId,String blockChainName) {
        this.blockChainId = blockChainId;
        this.blockChainName = blockChainName;
    }

    public CreateBlockChain() {

    }

    public String getBlockChainId() {
        return blockChainId;
    }

    public String getBlockChainName() {
        return blockChainName;
    }
}

package com.sofka.albertus.domain.commands;

import co.com.sofka.domain.generic.Command;

public class CreateBlock extends Command {

    private String blockChainID;
    private String applicationID;
    private String data;

    public CreateBlock(String blockChainID, String applicationID, String data) {
        this.blockChainID = blockChainID;
        this.applicationID = applicationID;
        this.data = data;
    }

    public CreateBlock() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getData() {
        return data;
    }

    public String getBlockChainID() {
        return blockChainID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }
}

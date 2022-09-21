package com.sofka.albertus.domain.commands;

import co.com.sofka.domain.generic.Command;

public class CreateBlock extends Command {

    private String applicationID;
    private String data;

    public CreateBlock(String applicationID, String data) {
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
}

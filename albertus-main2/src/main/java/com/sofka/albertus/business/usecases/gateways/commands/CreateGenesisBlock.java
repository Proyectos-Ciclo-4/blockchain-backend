package com.sofka.albertus.business.usecases.gateways.commands;

import co.com.sofka.domain.generic.Command;

import java.time.Instant;

public class CreateGenesisBlock extends Command {


    private String data;

    public CreateGenesisBlock() {
    }

    public CreateGenesisBlock(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

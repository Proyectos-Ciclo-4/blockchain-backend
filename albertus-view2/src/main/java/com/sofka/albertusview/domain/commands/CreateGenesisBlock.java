package com.sofka.albertusview.domain.commands;

import co.com.sofka.domain.generic.Command;

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

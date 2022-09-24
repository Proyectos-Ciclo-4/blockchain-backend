package com.sofka.albertus.business.usecases.gateways.commands;

import co.com.sofka.domain.generic.Command;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sofka.albertus.application.helpers.CustomJson;

import java.util.Map;
import java.util.Objects;

public class CreateBlock extends Command {

    private String blockChainID = "1";
    private String applicationID;

    private Map<String, String> data;

    public CreateBlock( String applicationID,  Map<String, String>  data) {
        this.blockChainID = "1";
        this.applicationID = applicationID;
        this.data = data;
    }

    public CreateBlock() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public Map getData() {
        return data;
    }

    public String getBlockChainID() {
        return blockChainID;
    }

    public void setBlockChainID(String blockChainID) {
        this.blockChainID = blockChainID;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }
}

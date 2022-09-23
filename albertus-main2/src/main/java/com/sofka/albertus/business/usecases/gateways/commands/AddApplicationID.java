package com.sofka.albertus.business.usecases.gateways.commands;

import co.com.sofka.domain.generic.Command;

public class AddApplicationID extends Command {

    private String applicationID;
    private String userID;

    public AddApplicationID(String applicationID, String userID) {
        this.applicationID = applicationID;
        this.userID = userID;
    }

    public AddApplicationID() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getUserID() {
        return userID;
    }
}

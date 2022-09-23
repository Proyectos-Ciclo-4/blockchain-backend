package com.sofka.albertus.business.usecases.gateways.commands;

import co.com.sofka.domain.generic.Command;

public class DeleteApplication extends Command {


    private String applicationID;

    public DeleteApplication(String applicationID) {
        this.applicationID = applicationID;
    }

    public DeleteApplication() {
    }

    public String getApplicationID() {
        return applicationID;
    }
}

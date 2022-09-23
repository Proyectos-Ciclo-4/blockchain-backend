package com.sofka.albertus.business.usecases.gateways.commands;

import co.com.sofka.domain.generic.Command;

public class UpdateApplication extends Command {

    private String applicationID;
    private String nameApplication;
    private String description;

    public UpdateApplication(String applicationID, String nameApplication, String description) {
        this.applicationID = applicationID;
        this.nameApplication = nameApplication;
        this.description = description;
    }

    public UpdateApplication() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getNameApplication() {
        return nameApplication;
    }

    public String getDescription() {
        return description;
    }
}

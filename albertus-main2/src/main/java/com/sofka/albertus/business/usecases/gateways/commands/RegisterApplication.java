package com.sofka.albertus.business.usecases.gateways.commands;

import co.com.sofka.domain.generic.Command;

public class RegisterApplication extends Command {


    //TODO por poner en el evento recordatorio de que cuando se crea un aplicativo se debe hacer el
    //TODO set up del applicationID en el user en firebase

    private String applicationId;
    private String nameApplication;
    private String description;
    private Boolean isActive;
    private String userId;


    public RegisterApplication(String applicationId, String nameApplication, String description, Boolean isActive, String userId) {
        this.applicationId = applicationId;
        this.nameApplication = nameApplication;
        this.description = description;
        this.isActive = isActive;
        this.userId = userId;
    }

    public RegisterApplication() {
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getNameApplication() {
        return nameApplication;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getUserId() {
        return userId;
    }
}

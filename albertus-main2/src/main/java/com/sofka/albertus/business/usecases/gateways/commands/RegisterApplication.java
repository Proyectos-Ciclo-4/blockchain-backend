package com.sofka.albertus.business.usecases.gateways.commands;

import co.com.sofka.domain.generic.Command;

public class RegisterApplication extends Command {


    //TODO por poner en el evento recordatorio de que cuando se crea un aplicativo se debe hacer el
    //TODO set up del applicationID en el user en firebase
    private String nameApplication;
    private String description;

    public RegisterApplication(String nameApplication, String description) {
        this.nameApplication = nameApplication;
        this.description = description;
    }

    public RegisterApplication() {
    }

    public String getNameApplication() {
        return nameApplication;
    }

    public String getDescription() {
        return description;
    }
}

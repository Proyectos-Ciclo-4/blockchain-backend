package com.sofka.albertusview.domain.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.albertusview.domain.values.ApplicationId;
import com.sofka.albertusview.domain.values.Description;
import com.sofka.albertusview.domain.values.IsActive;
import com.sofka.albertusview.domain.values.Name;


public class Application extends Entity<ApplicationId> {

    private Name nameApplication;
    private Description description;
    private IsActive isActive;


    public Application(ApplicationId entityId,
                       Name nameApplication,
                       Description description,
                       IsActive isActive) {

        super(entityId);
        this.nameApplication = nameApplication;
        this.description = description;
        this.isActive = isActive;
    }

    public Name getNameApplication() {
        return nameApplication;
    }

    public void setNameApplication(Name nameApplication) {
        this.nameApplication = nameApplication;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public IsActive getIsActive() {
        return isActive;
    }

    public void setIsActive(IsActive isActive) {
        this.isActive = isActive;
    }
}

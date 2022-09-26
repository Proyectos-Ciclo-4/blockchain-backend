package com.sofka.albertus.domain.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.albertus.domain.values.*;

public class Application extends Entity<ApplicationId> {

    private Name nameApplication;
    private Description description;
    private IsActive isActive;
    private UserId userId;

    private CreationDate creationDate;

    private ModificationDate modificationDate;

    public Application(ApplicationId entityId,
                       Name nameApplication,
                       Description description,
                       IsActive isActive,
                       UserId userId,
                       CreationDate creationDate,
                       ModificationDate modificationDate) {

        super(entityId);
        this.nameApplication = nameApplication;
        this.description = description;
        this.isActive = isActive;
        this.userId = userId;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
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

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public CreationDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(CreationDate creationDate) {
        this.creationDate = creationDate;
    }

    public ModificationDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(ModificationDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void updateApplication(String nameApplication, String descriptionApplication){
        this.nameApplication = new Name(nameApplication);
        this.description = new Description(descriptionApplication);
    }

    public  void deleteApplication(){
        this.isActive = new IsActive(false);
    }

}

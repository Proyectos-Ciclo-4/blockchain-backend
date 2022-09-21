package com.sofka.albertus.domain.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.albertus.domain.values.*;

import java.util.Set;

public class User extends Entity<UserId> {

    private  FullName fullName;
    private Email email;
    private Password password;
    private Set<ApplicationId> applicationIds;


    public User(UserId userId,
                FullName fullName,
                Email email,
                Password password,
                Set<ApplicationId> applicationIds) {
        super(userId);
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.applicationIds = applicationIds;
    }



    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Set<ApplicationId> getApplicationIds() {
        return applicationIds;
    }

    public void setApplicationIds(Set<ApplicationId> applicationIds) {
        this.applicationIds = applicationIds;
    }
}

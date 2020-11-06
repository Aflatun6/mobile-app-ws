package com.avelibeyli.app.mobileappws.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUser {

    @NotNull(message = "must be not null")
    private String name;

    @NotNull(message = "must be not null")
    private String lastName;

    public UpdateUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

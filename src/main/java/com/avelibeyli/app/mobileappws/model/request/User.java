package com.avelibeyli.app.mobileappws.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull(message = "must be not null")
    private String name;

    @NotNull(message = "must be not null")
    private String lastName;

    @NotNull(message = "must be not null")
    @Email
    private String mail;

    @NotNull(message = "must be not null")
    @Size(min = 8, max = 30, message = "must be between 8 to 30 characters")
    private String password;

    public User() {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

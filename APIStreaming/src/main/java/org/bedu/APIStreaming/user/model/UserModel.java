package org.bedu.APIStreaming.user.model;

public class UserModel {
    private String lastName;
    private String fistName;
    private String email;

    public UserModel(String lastName, String fistName, String email) {
        this.lastName = lastName;
        this.fistName = fistName;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
package com.example.roombookingapp;

import java.io.Serializable;

public class LoginResult implements Serializable {

    private String name;
    private String email;
    private String phoneNumber;
    private String profession;

    public String getProfession() {
        return profession;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

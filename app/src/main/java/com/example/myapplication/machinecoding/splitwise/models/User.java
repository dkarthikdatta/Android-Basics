package com.example.myapplication.machinecoding.splitwise.models;

public class User {
    private int userId;
    private String name;
    private String email;
    private String mobileNumber;


    public User(int userId, String name, String email, String mobileNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

package com.vnext.entity;

public class UserAccount {
    private String userName;
    private boolean gender;
    private String password;

    public UserAccount() {
    }


    public UserAccount(String userName, boolean gender, String password) {
        this.userName = userName;
        this.gender = gender;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

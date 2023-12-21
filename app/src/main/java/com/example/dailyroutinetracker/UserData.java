package com.example.dailyroutinetracker;

import java.security.PublicKey;

public class UserData {
    private String userName;
    private String userEmailId;

    public UserData(){}
    public UserData(String userName, String userEmailId) {
        this.userName = userName;
        this.userEmailId = userEmailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }
}

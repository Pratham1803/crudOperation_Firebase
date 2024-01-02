package com.example.crudInFireBase;

public class UserData {
    private String userId;
    private String userName;
    private String userEmailId;

    public UserData() {
    }

    public UserData(String userName, String userEmailId) {
        this.userName = userName;
        this.userEmailId = userEmailId;
    }

    public UserData(String userId, String userName, String userEmailId) {
        this.userId = userId;
        this.userName = userName;
        this.userEmailId = userEmailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }
}

package com.ssumc.crud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public char getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(char userStatus) {
        this.userStatus = userStatus;
    }

    public char getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(char userGrade) {
        this.userGrade = userGrade;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String password;
    private String userEmail;
    private String userPhone;
    private char userStatus;
    private char userGrade;


}

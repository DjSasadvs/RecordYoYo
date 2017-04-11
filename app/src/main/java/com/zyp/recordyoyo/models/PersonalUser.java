package com.zyp.recordyoyo.models;

import java.util.UUID;

/**
 * User Module
 * Created by zyp on 2016/1/26.
 */
public class PersonalUser {
    //User|Pas|KeyId|Uuid|
    UUID userKey;
    String userName;
    String userId;
    String userEmail;
    String userPhone;

    public UUID getUserKey() {
        return userKey;
    }

    public void setUserKey(UUID userKey) {
        this.userKey = userKey;
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

    //create a new user
    public boolean createUser(String userName, String userPass, String userPhone) {
        boolean isCreateSucess = false;
        return isCreateSucess;
    }

    //edit the user info
    public boolean editUser(String userName, String userPass, String userPhone) {
        boolean isEditSucess = false;
        return isEditSucess;
    }

    //delete the user
    public boolean deleteUser() {
        boolean isDeleteSucess = false;
        return isDeleteSucess;
    }
}

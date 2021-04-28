package com.codecool.shop.model;

import com.codecool.shop.dao.implementation.UserDaoMem;

import java.util.UUID;

public class User{
    private String username;
    private String password;
    private String id;

    public User(String username, String password) {
        this.username = username;
        this.password = password;


    }
    public void setUser(User user) {
    }

    public void setId(String id) {
    }

    public String getId() {
        return id;
    }
}

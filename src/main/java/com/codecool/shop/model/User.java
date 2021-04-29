package com.codecool.shop.model;

import com.codecool.shop.dao.implementation.UserDaoMem;

import java.util.UUID;

public class User{
    private String username;
    private String password;
    private String id;
    private boolean loggedIn;

    public User(String username, String password) {
        this.username = username;
        this.password = password;


    }
    public void setUser(User user) {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}

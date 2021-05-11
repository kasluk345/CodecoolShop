package com.codecool.shop.dao;

import com.codecool.shop.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    User find(String id);
    User findByUsername(String username);
    void remove(String id);
    List<User> getAll();
}

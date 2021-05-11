package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDaoMem implements UserDao {
    private List<User> data = new ArrayList<>();
    private static UserDaoMem instance = null;


    private UserDaoMem() {
    }

    public static UserDaoMem getInstance() {
        if (instance == null) {
            instance = new UserDaoMem();
        }
        return instance;
    }

    @Override
    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
        data.add(user);
    }

    @Override
    public User find(String id) {
        return data.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);    }

    public User findByUsername(String username) {
        return data.stream().filter(t -> t.getUsername().equals(username)).findFirst().orElse(null);    }

    @Override
    public void remove(String id) {
        data.remove(find(id));
    }

    @Override
    public List<User> getAll() {
        return data;
    }
}

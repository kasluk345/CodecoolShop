package com.codecool.shop.serialization;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.UserDaoMem;
import com.codecool.shop.model.User;

public class UserParamsSerializer {

    public User mapFromParams(String body) {
        UserDao userDao = UserDaoMem.getInstance();
        String[] fields = body.split("&");
        User user = new User(fields[0].split("=")[1], fields[1].split("=")[1]);

        return user;
    }
}

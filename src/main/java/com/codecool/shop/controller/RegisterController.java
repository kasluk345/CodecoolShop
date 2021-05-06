package com.codecool.shop.controller;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.UserDaoMem;
import com.codecool.shop.serialization.UserParamsSerializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController {
    private final UserParamsSerializer userSerializer = new UserParamsSerializer();
    private UserDao userDao = UserDaoMem.getInstance();

    public RegisterController(UserDao userDao) {
        this.userDao = userDao;
    }

    public RegisterController() {

    }

    public void handlePOST(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().readLine();
        userDao.add(userSerializer.mapFromParams(body));
        System.out.println(userDao.getAll());
    }
}


package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.UserDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.User;
import com.codecool.shop.serialization.UserParamsSerializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginService{
    private final UserParamsSerializer userSerializer = new UserParamsSerializer();
    private AuthService authService = new AuthService();

    public void handlePOSTLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().readLine();
        User user = userSerializer.mapFromParams(body);
        authService.authenticate(user);
        if (authService.checkLoggedIn(user));
        resp.sendRedirect("/");
    }
}

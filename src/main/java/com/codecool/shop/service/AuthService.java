package com.codecool.shop.service;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.UserDaoMem;
import com.codecool.shop.model.User;

public class AuthService {
    private UserDao userDao = UserDaoMem.getInstance();

    public AuthService() {
    }

    public void authenticate(User user) {
        checkIfUserInMem(user);
        if (user.getUsername() != "") {
            checkCredentials(user);
        } else {
            System.out.println("Auth error");
        }
    }

    public boolean checkIfMemEmpty() {
        if (userDao.getAll().size() == 0) {
            return true;
        } else {
            return false;
        }
    }


    public String checkIfUserInMem(User user) {
        userDao.getAll().toString();
        for (User u : userDao.getAll()) {
            String username = user.getUsername();
            if (u.getUsername().equals(username)) {
                return username;
            } else {
                System.out.println("There is no user with username:" + u.getUsername());
                return "";
            }
        }
        return "";
    }

    public void checkCredentials(User user) {
        if (!checkIfMemEmpty()) {
            User user1 = user;
            User user2 = userDao.findByUsername(user.getUsername());
            if (user2 != null) {
                if (user1.getUsername().equals(user2.getUsername()) &&
                        user1.getPassword().equals(user2.getPassword())) {
                    System.out.println("logged in successful");
                    user2.setLoggedIn(true);
                } else {
                    System.out.println("wrong password");
                }
            }
        }
    }

    public boolean checkLoggedIn(User user) {
        if (!checkIfMemEmpty()) {
            if (checkIfUserInMem(user) != "") {
                return userDao.findByUsername(user.getUsername()).isLoggedIn();
            }
        }
        return false;
    }
}

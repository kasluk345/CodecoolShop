package com.codecool.shop.service;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.UserDaoMem;
import com.codecool.shop.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthService {
    private User user;
    private UserDao userDao = UserDaoMem.getInstance();
    private List<User> users = userDao.getAll();
    List<String> ids = new ArrayList<>();
    List<String> usernames = new ArrayList<>();


    public AuthService(User user) {
        this.user = user;
        for (User u : users) {
            usernames.add(user.getUsername());
        }
    }

    public void authenticate() {
        String username = checkIfUserInMem();
        if (username != "") {
            checkCredentials(username);
        } else {
            System.out.println("Auth error");
        }
    }



    public String checkIfUserInMem() {
        for (String username : this.usernames) {
            if (this.getUser().getUsername().equals(username)) {
                return username;
            } else {
                System.out.println("There is no user with username:" + this.getUser().getUsername());
                return "";
            }
        }
        return "";
    }

    public void checkCredentials(String username) {
        User user1 = this.getUser();
        User user2 = userDao.findByUsername(username);
       if (user1.getUsername().equals(user2.getUsername()) &&
           user1.getPassword().equals(user2.getPassword())){
           System.out.println("logged in successful");
           user1.setLoggedIn(true);
       } else {
           System.out.println("wrong password");
       }
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean checkLoggedIn(String username) {
        return userDao.findByUsername(username).isLoggedIn();
    }


}

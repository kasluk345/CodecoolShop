package com.codecool.shop.dao;

import com.codecool.shop.model.Order;
import com.codecool.shop.model.Payment;
import com.codecool.shop.model.User;

import java.util.List;

public interface OrderDao {
    void add(Order order);
    Order find(String id);
    void remove(String id);
    List<Order> getAll();
}

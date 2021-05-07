package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderDaoMem implements OrderDao {
    private List<Order> data = new ArrayList<>();
    private static OrderDaoMem instance = null;


    private OrderDaoMem() {
    }

    public static OrderDaoMem getInstance() {
        if (instance == null) {
            instance = new OrderDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Order order) {
        order.setId(UUID.randomUUID().toString());
        data.add(order);
    }

    @Override
    public Order find(String id) {
        return data.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);    }

    @Override
    public void remove(String id) {
        data.remove(find(id));
    }

    @Override
    public List<Order> getAll() {
        return data;
    }
}

package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private Date date;
    private List<Product> products = new ArrayList<>();
    private DeliveryAddress deliveryAddress;
    private Payment payment;
    private User user;


    public Order(String id, Date date, User user) {
        this.id = id;
        this.date = date;
        this.user = user;
    }
}

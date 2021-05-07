package com.codecool.shop.dao;

import com.codecool.shop.model.Payment;
import com.codecool.shop.model.User;

import java.util.List;

public interface PaymentDao {
    void add(Payment payment);
    Payment find(String id);
    void remove(String id);
    List<Payment> getAll();
}

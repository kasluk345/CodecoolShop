package com.codecool.shop.dao;

import com.codecool.shop.model.DeliveryAddress;
import com.codecool.shop.model.Payment;
import com.codecool.shop.model.User;

import java.util.List;

public interface DeliveryAddressDao {
    void add(DeliveryAddress deliveryAddress);
    DeliveryAddress find(String id);
    void remove(String id);
    List<DeliveryAddress> getAll();
}

package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.DeliveryAddressDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.DeliveryAddress;
import com.codecool.shop.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DeliveryAddressDaoMem implements DeliveryAddressDao {
    private List<DeliveryAddress> data = new ArrayList<>();
    private static DeliveryAddressDaoMem instance = null;


    private DeliveryAddressDaoMem() {
    }

    public static DeliveryAddressDaoMem getInstance() {
        if (instance == null) {
            instance = new DeliveryAddressDaoMem();
        }
        return instance;
    }

    @Override
    public void add(DeliveryAddress deliveryAddress) {
        deliveryAddress.setId(UUID.randomUUID().toString());
        data.add(deliveryAddress);
    }

    @Override
    public DeliveryAddress find(String id) {
        return data.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);    }

    @Override
    public void remove(String id) {
        data.remove(find(id));
    }

    @Override
    public List<DeliveryAddress> getAll() {
        return data;
    }
}
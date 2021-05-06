package com.codecool.shop.serialization;

import com.codecool.shop.model.DeliveryAddress;
import com.codecool.shop.model.User;

public class DeliveryAddressSerializer {
    public DeliveryAddress mapFromParams(String body) {
        return new DeliveryAddress("xxx", "yyy", "aaa", 1, 2, "aa-bbb", "bbb");
    }
}

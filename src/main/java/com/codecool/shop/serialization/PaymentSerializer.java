package com.codecool.shop.serialization;

import com.codecool.shop.model.Payment;

import java.util.Date;

public class PaymentSerializer {
    public Payment mapFromParams(String body) {
        return new Payment("aaa", 0000, new Date(222), "sasda");
    }
}

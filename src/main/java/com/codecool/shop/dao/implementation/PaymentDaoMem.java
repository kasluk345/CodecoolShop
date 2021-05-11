package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.PaymentDao;
import com.codecool.shop.model.Payment;
import com.codecool.shop.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaymentDaoMem implements PaymentDao {
    private List<Payment> data = new ArrayList<>();
    private static PaymentDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private PaymentDaoMem() {
    }

    public static PaymentDaoMem getInstance() {
        if (instance == null) {
            instance = new PaymentDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Payment payment) {
        payment.setId(UUID.randomUUID().toString());
        data.add(payment);

    }

    @Override
    public Payment find(String id) {
        return data.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void remove(String id) {
        data.remove(find(id));

    }

    @Override
    public List<Payment> getAll() {
        return data;
    }
}

package com.codecool.shop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private LocalDateTime localDateTime;
    private User user;
    private List<Product> products = new ArrayList<>();
    private DeliveryAddress deliveryAddress;
    private Payment payment;


    public Order(LocalDateTime localDateTime, List<Product> products, DeliveryAddress deliveryAddress, Payment payment) {
        this.localDateTime = localDateTime;
        this.products = products;
        this.deliveryAddress = deliveryAddress;
        this.payment = payment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    public String getStringToPrint(){
        String string = "";
        string+= this.getId() + this.getLocalDateTime();

        return string;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", localDateTime=" + localDateTime +
                ", user=" + user +
                ", products=" + products +
                ", deliveryAddress=" + deliveryAddress +
                ", payment=" + payment +
                '}';
    }
}

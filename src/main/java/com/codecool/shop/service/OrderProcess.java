package com.codecool.shop.service;

import com.codecool.shop.dao.DeliveryAddressDao;
import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.model.DeliveryAddress;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class OrderProcess {
    private OrderDao orderDao = OrderDaoMem.getInstance();
    private static OrderProcess instance = null;
    private OrderService orderService;
    private DeliveryAddress deliveryAddress;
    private Payment payment;
    private Order order;



    private OrderProcess() {
    }

    public static OrderProcess getInstance() {
        if (instance == null) {
            instance = new OrderProcess();
        }
        return instance;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public static void setInstance(OrderProcess instance) {
        OrderProcess.instance = instance;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

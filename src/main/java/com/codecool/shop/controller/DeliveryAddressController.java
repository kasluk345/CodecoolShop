package com.codecool.shop.controller;

import com.codecool.shop.dao.DeliveryAddressDao;
import com.codecool.shop.dao.implementation.DeliveryAddressDaoMem;
import com.codecool.shop.model.DeliveryAddress;
import com.codecool.shop.model.User;
import com.codecool.shop.serialization.DeliveryAddressSerializer;
import com.codecool.shop.service.OrderProcess;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeliveryAddressController {
    private final DeliveryAddressSerializer deliveryAddressSerializer = new DeliveryAddressSerializer();
    private DeliveryAddressDao deliveryAddressDao = DeliveryAddressDaoMem.getInstance();
    OrderProcess orderProcess = OrderProcess.getInstance();


    public void handlePOSTLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().readLine();
        DeliveryAddress deliveryAddress = deliveryAddressSerializer.mapFromParams(body);
        deliveryAddressDao.add(deliveryAddress);
        orderProcess.setDeliveryAddress(deliveryAddress);
        resp.sendRedirect("/payment");
    }
}

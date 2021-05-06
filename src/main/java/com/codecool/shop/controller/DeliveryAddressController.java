package com.codecool.shop.controller;

import com.codecool.shop.model.DeliveryAddress;
import com.codecool.shop.model.User;
import com.codecool.shop.serialization.DeliveryAddressSerializer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeliveryAddressController {
    private final DeliveryAddressSerializer deliveryAddressSerializer = new DeliveryAddressSerializer();

    public void handlePOSTLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().readLine();
        DeliveryAddress deliveryAddress = deliveryAddressSerializer.mapFromParams(body);
        System.out.println(body + "address to serialize");
        resp.sendRedirect("/payment");
    }
}

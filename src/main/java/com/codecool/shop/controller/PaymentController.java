package com.codecool.shop.controller;

import com.codecool.shop.model.DeliveryAddress;
import com.codecool.shop.model.Payment;
import com.codecool.shop.serialization.PaymentSerializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PaymentController {
    PaymentSerializer paymentSerializer = new PaymentSerializer();

    public void handlePOSTLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().readLine();
        Payment payment = paymentSerializer.mapFromParams(body);
        System.out.println(body + "payment to serialize");
//        resp.sendRedirect("/send-order");
        resp.sendRedirect("/");
    }
}

package com.codecool.shop.controller;
import com.codecool.shop.dao.PaymentDao;
import com.codecool.shop.dao.implementation.PaymentDaoMem;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.Payment;
import com.codecool.shop.serialization.PaymentSerializer;
import com.codecool.shop.service.OrderProcess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class PaymentController {
    PaymentSerializer paymentSerializer = new PaymentSerializer();
    PaymentDao paymentDao = PaymentDaoMem.getInstance();
    OrderProcess orderProcess = OrderProcess.getInstance();

    public void handlePOSTLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().readLine();
        System.out.println(body + "payment to serialize");
        Payment payment = paymentSerializer.mapFromParams(body);
        paymentDao.add(payment);
        orderProcess.setPayment(payment);
        Order order = new Order(LocalDateTime.now(), orderProcess.getOrderService().getAllProducts(), orderProcess.getDeliveryAddress(), orderProcess.getPayment());
        resp.sendRedirect("/order-summary");
    }
}

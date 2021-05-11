package com.codecool.shop.servlet;


import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.Order;
import com.codecool.shop.service.OrderProcess;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = {"/order-summary"})
public class OrderSummaryServlet extends HttpServlet {
    OrderProcess orderProcess = OrderProcess.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("products", orderProcess.getOrderService().getAllProducts());
        context.setVariable("totalPrice", orderProcess.getOrderService().getTotalPrice());
        context.setVariable("delivery", orderProcess.getDeliveryAddress());
        context.setVariable("payment", orderProcess.getPayment());
        engine.process("order-summary.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order(LocalDateTime.now(), orderProcess.getOrderService().getAllProducts(), orderProcess.getDeliveryAddress(), orderProcess.getPayment());
        System.out.println(order);
        resp.sendRedirect("/");
    }
}

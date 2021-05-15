package com.codecool.shop.servlet;

import com.codecool.shop.model.DeliveryAddress;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.Payment;
import com.codecool.shop.service.OrderProcess;
import com.codecool.shop.service.OrderService;
import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


@WebServlet(urlPatterns = {"/confirm-order"})
public class OrderController extends HttpServlet {
    OrderProcess orderProcess = OrderProcess.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = new OrderService(req.getSession().getAttribute("userID").toString());
        orderProcess.setOrderService(orderService);
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("totalPrice", orderService.getTotalPrice());
        context.setVariable("products", orderService.getAllProducts());
        context.setVariable("user", req.getSession().getAttribute("user").toString());
        engine.process("confirm-order.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String frontData = req.getReader().readLine();
        System.out.println("\nLOG (OrderController-l30)| data from confirm_order.html:");
        System.out.println(frontData);
        resp.sendRedirect("/");
    }
}

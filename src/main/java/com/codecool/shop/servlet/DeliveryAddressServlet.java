package com.codecool.shop.servlet;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.controller.DeliveryAddressController;
import com.codecool.shop.controller.LoginController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/delivery-address"})
public class DeliveryAddressServlet extends HttpServlet {
    private DeliveryAddressController deliveryAddressController;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        engine.process("delivery-address.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeliveryAddressController deliveryAddressController = new DeliveryAddressController();
        deliveryAddressController.handlePOSTLogin(req, resp);
    }


}

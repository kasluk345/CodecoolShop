package com.codecool.shop.servlet;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.controller.LoginController;
import com.codecool.shop.controller.PaymentController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(urlPatterns = {"/payment"})
    public class PaymentServlet extends HttpServlet {
        private PaymentController paymentController;


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
            WebContext context = new WebContext(req, resp, req.getServletContext());
            engine.process("payment.html", context, resp.getWriter());
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PaymentController paymentController = new PaymentController();
            paymentController.handlePOSTLogin(req, resp);
        }
    }
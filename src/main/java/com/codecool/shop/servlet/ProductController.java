package com.codecool.shop.servlet;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.User;
import com.codecool.shop.service.CategoryService;
import com.codecool.shop.service.OrderService;
import com.codecool.shop.service.ProductService;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.service.SuppliersService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/","/api/product/add","/api/product/del"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String sessionID=session.getId();

        //TODO rethink below code: check if user logged, add user and userID to session after login
        if (session.getAttribute("userID") == null) {  //no userID in session means user not logged
            User user = new User("guest", "");
            user.setId(sessionID);
            session.setAttribute("user",user); //set user to session
            session.setAttribute("userID",user.getId());
            System.out.println("LOG: ProductController-l40| Session info: "+session + " USER: "+user.getUsername());
        } else {
            //User user = get user by ID from memory;
            User user = (User) session.getAttribute("user"); //get current user from session
            System.out.println("LOG: ProductController-l40| Session info: "+session + " USER: "+user.getUsername());
        }



        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        ProductService productService = new ProductService(productDataStore, productCategoryDataStore, supplierDataStore);
        CategoryService categoryService = new CategoryService(productCategoryDataStore);
        SuppliersService suppliersService = new SuppliersService(supplierDataStore);

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("suppliers", suppliersService.getSuppliers());
        context.setVariable("products", productService.getAllProducts());
        context.setVariable("categories", categoryService.getAllCategories());
        context.setVariable("user", session.getAttribute("user").toString());

        engine.process("product/index.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID = req.getSession().getAttribute("userID").toString();
        OrderService orderService = new OrderService(userID);
        orderService.handlePostProduct(req, resp,userID);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID = req.getSession().getAttribute("userID").toString();
        OrderService orderService = new OrderService(userID);
        orderService.handleDeleteProduct(req, resp,userID);
    }


}
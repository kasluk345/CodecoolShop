package com.codecool.shop.servlet;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.serialization.ProductSerializer;
import com.codecool.shop.service.CategoryService;
import com.codecool.shop.service.OrderService;
import com.codecool.shop.service.ProductService;
import com.google.gson.JsonObject;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


//URL to share data with JavaScript
@WebServlet(urlPatterns = {"/api/product/get"})
public class CodecoolShopAPI extends HttpServlet {
    private ProductSerializer productSerializer = new ProductSerializer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> products = CartDaoMem.getUserCart(req.getSession().getAttribute("userID").toString()).getAll(); //products in user Cart
        //List<Product> products = productService.getAllProducts(); // all products avaliable in shop

        if(products.size()>0) {
            String productsJSON = "";
            for (Product product : products)
                productsJSON += productSerializer.stringFromProduct(product) + ",";
            productsJSON = productsJSON.substring(0, productsJSON.length() - 1); //remove last character from String ","

            //prepare JSON array format and print
            String userJsonString = "{\"ProductsInCart\":[" + productsJSON + "]}";
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print(userJsonString);
            out.flush();
        }
    }

}

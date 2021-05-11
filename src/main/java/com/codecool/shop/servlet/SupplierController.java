package com.codecool.shop.servlet;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.service.CategoryService;
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
import java.io.IOException;

@WebServlet(urlPatterns = {"/products/supplier/*"})
public class SupplierController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String supplierId = req.getPathInfo().substring(1);
        int supplierIdInt= Integer.parseInt(supplierId);
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        ProductService productService = new ProductService(productDataStore, productCategoryDataStore, supplierDataStore);
        CategoryService categoryService = new CategoryService(productCategoryDataStore);
        SuppliersService suppliersService = new SuppliersService(supplierDataStore);

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        ProductCategory category = productService.getProductCategoryByUrl(req.getParameter("category"));
        if(category == null){
            context.setVariable("products", productService.getProductsForSupplier(supplierIdInt));
        }else {
            context.setVariable("category", category);
            context.setVariable("products", productService.getProductsForCategoryAndSupplier(category.getId(), supplierIdInt));
        }
        context.setVariable("suppliers", suppliersService.getSuppliers());
        context.setVariable("categories", categoryService.getAllCategories());
        engine.process("product/supplier.html", context, resp.getWriter());
    }

}

package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier ollivanders = new Supplier("Ollivanders", "Magic wands");
        supplierDataStore.add(ollivanders);
        Supplier flounshAndBlotts = new Supplier("Flounsh and Blotts", "Schoolbooks");
        supplierDataStore.add(flounshAndBlotts);
        Supplier eeylopsOwlEmporium = new Supplier("Eeylops Owl Emporium", "Owls");
        supplierDataStore.add(eeylopsOwlEmporium);
        Supplier broomShop = new Supplier("Broom Shop", "Brooms");
        supplierDataStore.add(broomShop);

        //setting up a new product category
        ProductCategory magic_wand = new ProductCategory("magic_wand", "Wand",
                "A wand is a quasi-sentient magical instrument through which a witch or wizard channels her or his magical powers to centralise the effects for more complex results. ");
        productCategoryDataStore.add(magic_wand);

        ProductCategory magic_book = new ProductCategory("magic_book", "Schoolbook",
                "Magic textbooks allow Hogwarts students to explore the secrets of the world of magic.");
        productCategoryDataStore.add(magic_book);

        //setting up products and printing it
        productDataStore.add(new Product("Amazing Magic Wand", 49.9f, "USD",
                "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", magic_wand, ollivanders));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", 479, "USD",
                "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", magic_book, flounshAndBlotts));
        productDataStore.add(new Product("Amazon Fire HD 8", 89, "USD",
                "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", magic_wand, eeylopsOwlEmporium));
        productDataStore.add(new Product("Dumbledore's magic wand", 89, "USD",
                "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", magic_wand, broomShop));
    }
}

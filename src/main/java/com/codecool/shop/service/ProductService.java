package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductService{
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private SupplierDao supplierDao;

    public ProductService(ProductDao productDao, ProductCategoryDao productCategoryDao, SupplierDao supplierDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
        this.supplierDao = supplierDao;
    }

    public ProductCategory getProductCategory(int categoryId){
        return productCategoryDao.find(categoryId);
    }

    public List<Product> getProductsForCategory(int categoryId){
        var category = productCategoryDao.find(categoryId);
        return productDao.getBy(category);
    }

    public void handlePostProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public ProductCategory getProductCategoryByName(String categoryName) {
        return productCategoryDao.find(categoryName);
    }

    public ProductCategory getProductCategoryByUrl(String categoryUrl) {
        return productCategoryDao.findByUrl(categoryUrl);
    }

    public List<Product> getProductsForSupplier(int supplierId) {
        return productDao.getBySupplier(supplierId);
    }

    public Object getProductsForCategoryAndSupplier(int categoryId, int supplierId) {
        return productDao.getByCategoryAndSupplier(categoryId, supplierId);
    }

    public Product getProductById(int productId){
        return productDao.find(productId);
    }

}

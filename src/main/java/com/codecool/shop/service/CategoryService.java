package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

public class CategoryService{
    private ProductCategoryDao productCategoryDao;

    public CategoryService(ProductCategoryDao productCategoryDao) {
        this.productCategoryDao = productCategoryDao;
    }

    public ProductCategory getProductCategory(int categoryId){
        return productCategoryDao.find(categoryId);
    }

    public List <ProductCategory> getAllCategories(){
        return productCategoryDao.getAll();
    }
}

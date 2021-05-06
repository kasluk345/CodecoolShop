package com.codecool.shop.service;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import java.util.List;

public class SuppliersService {
    private SupplierDao supplierDao;

    public SuppliersService(SupplierDao supplierDao){
        this.supplierDao = supplierDao;
    }

    public List<Supplier> getSuppliers(){
        return supplierDao.getAll();
    }
}

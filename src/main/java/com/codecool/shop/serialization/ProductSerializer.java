package com.codecool.shop.serialization;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.UserDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.User;

import java.util.HashMap;

public class ProductSerializer {

    public Product mapFromParams(String body) {
        HashMap<String,String> productDict = new HashMap();
        body = body.replace("{\"","");
        body = body.replace("\"}","");

        String[] fields = body.split("\",\"");
        for(int i=0;i<fields.length;i++){
            //System.out.println(fields[i]);
            String[] splittedLine = fields[i].split("\":\" ");
            //System.out.println(i+"|"+splittedLine[0]+":"+splittedLine[1]);
            productDict.put(splittedLine[0],splittedLine[1]);
        }

        String id = productDict.get("id");
        String name = productDict.get("name");
        float price = Float.parseFloat(productDict.get("defaultPrice").replace(",","."));
        String currency = productDict.get("defaultCurrency");
        String description = "";
        ProductCategory category = new ProductCategory(productDict.get("productCategory"),"department","description");
        Supplier supplier = new Supplier(productDict.get("supplier"), "description");

        Product product = new Product(name,price,currency,description,category,supplier);
        product.setId(Integer.parseInt(id));

        System.out.println("LOG (ProductSerializer-l40)| Added product: "+name);

        return product;
    }

    public String stringFromProduct(Product product) {
        //String x = "{\"key1\": \"value1\",\"key2\":\"value2\"}";
        String productString = "{";
        productString += "\"id\": \""+product.getId()+"\",";
        productString += "\"name\": \""+product.getName()+"\",";
        productString += "\"defaultPrice\": \""+product.getPrice()+"\",";
        productString += "\"description\": \""+product.getDescription()+"\",";
        productString += "\"productCategory\": \""+product.getProductCategory().getName()+"\",";
        productString += "\"supplier\": \""+product.getSupplier().getName()+"\"";
        productString+= "}";
       return productString;
    }
}

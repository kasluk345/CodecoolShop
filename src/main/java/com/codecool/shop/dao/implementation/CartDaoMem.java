package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CartDaoMem implements CartDao {

    private HashMap<Product,Integer> cartData = new HashMap<>();
    private List<Product> data = new ArrayList<>();
    private static CartDaoMem instance = null;
    private static List<CartDaoMem> carts = new ArrayList<>();
    private final String cartID;

    /* A private Constructor prevents any other class from instantiating.
     */
    private CartDaoMem(String userID) {
        this.cartID = userID;  //cartID = userID =>1user can have only 1cart
    }

/*    public static CartDaoMem getInstance(String userID) {
        if (instance == null) {
            instance = new CartDaoMem(userID);
        }
        return instance;
    }*/

    public static CartDaoMem getUserCart(String userID) {

        for (CartDaoMem cart : carts) {
            if (cart.getCartID().equals(userID)) {
                return cart;
            }
        }

        CartDaoMem newCart = new CartDaoMem(userID);
        carts.add(newCart);
        return newCart;
    }

    @Override
    public void add(Product product) {
        product.setId(product.getId());
        data.add(product);
    }

    @Override
    public Product find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public void removeAll() {
        List<Product> allProducts = getAll();
        allProducts.removeAll(allProducts);
    }

    @Override
    public List<Product> getAll() {
        return data;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return data.stream().filter(t -> t.getSupplier().equals(supplier)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return data.stream().filter(t -> t.getProductCategory().equals(productCategory)).collect(Collectors.toList());
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        List<Product> allProducts = getAll();

        try {
            for (Product product : allProducts) {
                totalPrice += Double.parseDouble(product.getPrice().split(" ")[0]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong data format"+ e);
        }

        return totalPrice;
    }

    private String getCartID() {
        return cartID;
    }

    public CartDaoMem find(String id) {
        return carts.stream().filter(t -> t.getCartID() == id).findFirst().orElse(null);
    }
}

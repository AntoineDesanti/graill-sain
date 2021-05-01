package com.graillsain.graillsain.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Cart {

    private int maxProductsAmount;
    private double maxPriceAuthorized;
    public static ArrayList<CartElement> productsInCart;

    public Cart(int maxProductsAmount, double maxPriceAuthorized) {
        this.maxProductsAmount = maxProductsAmount;
        this.maxPriceAuthorized = maxPriceAuthorized;
        initializeCartProducts();
    }

    public Cart(){
        this.maxPriceAuthorized = 3000;
        this.maxProductsAmount = 100;
        initializeCartProducts();
    }

    public void initializeCartProducts(){
        productsInCart.add(new CartElement(new Product("Oranges Bio", 1.64), 0.300));
        productsInCart.add(new CartElement(new Product("Aubergines", 1.34), 0.400));
        productsInCart.add(new CartElement(new Product("Pommes fermières", 2.01), 0.500));
        productsInCart.add(new CartElement(new Product("Bananes", 1.49), 0.300));
        productsInCart.add(new CartElement(new Product("Epinards", 1.24), 0.200));
    }


}


package com.graillsain.graillsain.Models;

import android.graphics.Bitmap;

import androidx.annotation.DrawableRes;

public class Product {
    private String name = "";
    private double pricePerKilo = 0;
    private @DrawableRes int image;

    public Product(String name, double pricePerKilo){
        this.name = name;
        this.pricePerKilo = pricePerKilo;
    }

    public Product(String name, double pricePerKilo, @DrawableRes int image){
        this.name = name;
        this.pricePerKilo = pricePerKilo;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerKilo() {
        return pricePerKilo;
    }

    public void setPricePerKilo(double pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }
}
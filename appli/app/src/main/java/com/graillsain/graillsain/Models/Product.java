package com.graillsain.graillsain.Models;

public class Product {
    private String name = "";
    private double pricePerKilo = 0;

    public Product(String name, double pricePerKilo){
        this.name = name;
        this.pricePerKilo = pricePerKilo;
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

package com.graillsain.graillsain.Models;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int id;
    private ArrayList<Product> products;
    private int total;
    private Date heurePassage;

    public Order(int id, ArrayList<Product> products, int total, Date heurePassage) {
        this.id = id;
        this.products = products;
        this.total = total;
        this.heurePassage = heurePassage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getHeurePassage() {
        return heurePassage;
    }

    public void setHeurePassage(Date heurePassage) {
        this.heurePassage = heurePassage;
    }
}

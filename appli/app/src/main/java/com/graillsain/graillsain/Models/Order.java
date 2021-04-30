package com.graillsain.graillsain.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Order {
    private int id;
    private ArrayList<Product> products;
    private int total;
    private DateFormat heurePassage = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.FRANCE);

    public Order(int id, ArrayList<Product> products, int total, DateFormat heurePassage) {
        this.id = id;
        this.products = products;
        this.total = total;
        this.heurePassage = heurePassage;
    }

    public double countTotal(){
        double somme = 0;
        for (int i = 0; i<products.size(); i++)
            somme += products.get(i).getPricePerKilo();
        return somme;
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

    public DateFormat getHeurePassage() {
        return heurePassage;
    }

    public void setHeurePassage(SimpleDateFormat heurePassage) {
        this.heurePassage = heurePassage;
    }
}

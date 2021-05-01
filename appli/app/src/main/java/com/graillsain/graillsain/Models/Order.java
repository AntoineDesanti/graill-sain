package com.graillsain.graillsain.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Order {
    private int id;
    private ArrayList<Product> products;
    private double total = 0;
    private Date heurePassage = Calendar.getInstance().getTime();
    private Consummer consummer;

    public Order(){

    }

    public Order(int id, ArrayList<Product> products, int total, Date heurePassage, Consummer conso) {
        this.id = id;
        this.products = products;
        this.total = total;
        this.heurePassage = heurePassage;
        this.consummer = conso;
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

    public double getTotal() {
        for ( Product p : products ) {
            total += p.getPricePerKilo();
        }
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

    public void setTotal(double total) {
        this.total = total;
    }

    public Consummer getConsummer() {
        return consummer;
    }

    public void setConsummer(Consummer consummer) {
        this.consummer = consummer;
    }
}

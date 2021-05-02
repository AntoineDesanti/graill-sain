package com.graillsain.graillsain.Models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Order {
    private int id;
    private ArrayList<CartElement> products;
    private double total = 0;
    private Date schedule = Calendar.getInstance().getTime();
    private Consummer consummer;

    public Order(){

    }

    public Order(int id, ArrayList<CartElement> products, Date schedule, Consummer conso) {
        this.id = id;
        this.products = products;
        this.schedule = schedule;
        this.consummer = conso;
        this.total = countTotal();
    }

    public double countTotal(){
        double somme = 0;
        for (int i = 0; i<products.size(); i++)
            somme += products.get(i).getProduct().getPricePerKilo()
                    * products.get(i).getWeight()
                    * products.get(i).getQuantity();
        return somme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<CartElement> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<CartElement> products) {
        this.products = products;
    }

    public double getTotal() {
        for ( CartElement p : products ) {
            total += p.getProduct().getPricePerKilo();
        }
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
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

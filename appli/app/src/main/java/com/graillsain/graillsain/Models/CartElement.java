package com.graillsain.graillsain.Models;

public class CartElement {
    private Product product;
    private double weight; //chosen weight expressed in Kilos
    private double quantity; //number of times the item has been bought

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public CartElement(Product product, double weight, double quantity) {
        this.product = product;
        this.weight = weight;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

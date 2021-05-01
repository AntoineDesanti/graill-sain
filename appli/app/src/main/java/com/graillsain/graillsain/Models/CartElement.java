package com.graillsain.graillsain.Models;

public class CartElement {
    private Product product;
    private double quantity; //chosen weight expressed in Kilos

    public CartElement(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}

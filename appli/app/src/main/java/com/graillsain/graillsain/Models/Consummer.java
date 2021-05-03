package com.graillsain.graillsain.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  Consummer {
    private String name;
    private ArrayList<CartElement> cartElements;

    public Consummer(String name){
        this.name = name;
        this.cartElements = Storage.cartElements;
    }

    public static Consummer Martin = new Consummer("Martin");

    public ArrayList<CartElement> getCartElements() {
        return cartElements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

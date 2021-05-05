package com.graillsain.graillsain.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.graillsain.graillsain.Models.Consummer.Martin;

public class Storage {
    public static ArrayList<Product> products = new ArrayList<Product>(Arrays.asList(
            new Fruit("Citron", 2.00),
            new Fruit("Fraise", 4.00),
            new Fruit("Orange", 1.00),
            new Fruit("Framboise", 8.00)
    ));

    public static ArrayList<CartElement> cartElements = new ArrayList<CartElement>(Arrays.asList(
            new CartElement(products.get(0), 1, 1),
            new CartElement(products.get(1), 0.5, 3),
            new CartElement(products.get(2), 2, 2),
            new CartElement(products.get(3), 0.25, 1)
    ));

    public static List<String> availableSlotsForTakingOrder = new ArrayList<String>(Arrays.asList(
            "Mercredi 05/05 : 19h-20h",
            "Jeudi 06/05 : 08h-09h",
            "Jeudi 06/05 : 11h-12h",
            "Jeudi 06/05 : 14h-15h",
            "Vendredi 07/05 : 9h-10h"
    ));

    public static Date date = new Date();
    public static ArrayList<Order> orders = new ArrayList<Order>(Arrays.asList(
            new Order((int) ((Math.random() * (9999-1000)) + 1000), Storage.cartElements, date, Martin),
            new Order((int) ((Math.random() * (9999-1000)) + 1000), Storage.cartElements, date, Martin),
            new Order((int) ((Math.random() * (9999-1000)) + 1000), Storage.cartElements, date, Martin)
    ));

    public static Order findOrderById(int id){
        for(Order o : orders){
            if(o.getId() == id) return o;
        }
        return null;
    }


}

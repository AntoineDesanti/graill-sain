package com.graillsain.graillsain.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Storage {
    public static ArrayList<Product> products = new ArrayList<Product>(Arrays.asList(
            new Fruit("Citron", 2),
            new Fruit("Fraise", 4),
            new Fruit("Orange", 1),
            new Fruit("Framboise", 8)
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

}

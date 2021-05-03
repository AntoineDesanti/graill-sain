package com.graillsain.graillsain.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  Consummer {
    private String name;

    public Consummer(String name){
        this.name = name;
    }

    public static Consummer Martin = new Consummer("Martin");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

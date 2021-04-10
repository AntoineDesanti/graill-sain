package com.graillsain.graillsain.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Producer {
    private String name;
    private double latitude;
    private double longitude;
    private Boolean isVerified;
    private ArrayList<String> catalogue;

    public Producer(String name, double latitude, double longitude, Boolean isVerified) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isVerified = isVerified;
    }

    //dummy data
    public static List<Producer> producers = Arrays.asList(
            new Producer("Chez Michèle", 43.57195, 7.11661, true),
            new Producer("La Ferme de Jean", 43.57479, 7.11970, false));


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public ArrayList<String> getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(ArrayList<String> catalogue) {
        this.catalogue = catalogue;
    }

    public Boolean getVerified() {
        return isVerified;
    }
}
package com.graillsain.graillsain.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Producer {
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private Boolean isVerified;
    private ArrayList<String> catalogue;

    public Producer(String name, String address, double latitude, double longitude, Boolean isVerified, ArrayList<String> catalogue) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isVerified = isVerified;
        this.catalogue = catalogue;
    }

    public Producer(String name, String address, double latitude, double longitude, Boolean isVerified) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isVerified = isVerified;
    }

    //dummy data
    public static List<Producer> producers = new ArrayList(Arrays.asList(
            new Producer("Chez Michèle", "81294 Callie Manors 3 - Hilton Head Island82898",43.57195, 7.11661, true),
            new Producer("La Ferme de Jean", "9178 Loy Parkway - Idaho Falls,  86468",43.57479, 7.11970, false),
            new Producer("Brasseur de bières Mathias", "670 Kovacek Island - Hammond,  27220", 43.73972040324239, 7.289801144604989, true),
            new Producer("Brin de paille","1335 Raleigh Vista - Rio Rancho, 30968", 43.74382040324239, 7.292801144604989, false),
            new Producer("Le Panier du Fermier","6903 Bechtelar View - Altoona, 92742", 43.136960735060036, 5.796301971237862, true),
            new Producer("Aux Bonnes herbes","657 Kling Junctions - Durham, 14247", 43.1374607, 5.79990197, false),
            new Producer("La Fraiserie de Marco","21516 Shania Underpass - Barnstable Town, 44467", 43.620800516589914, 7.092233040502278, true),
            new Producer("Fruits & Légumes", "04544 Cummerata Parkways - Sammamish, 50243", 43.62170516589914, 7.093133040502278, true)
            ));



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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

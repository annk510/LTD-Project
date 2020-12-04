package com.example.vongship_android.DTO;

public class NotificationDetails {
    private String name;
    private String distance;
    private String sales;
    private int image;

    public NotificationDetails(String name, String distance, String sales, int image) {
        this.name = name;
        this.distance = distance;
        this.sales = sales;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

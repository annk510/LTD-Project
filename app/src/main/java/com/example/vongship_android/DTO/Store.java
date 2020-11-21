package com.example.vongship_android.DTO;

public class Store {
    private String storeId;
    private String storeName;
    private String distance;
    private String sales;
    private int img;

    public Store() {
    }

    public Store( String storeName, String distance, String sales, int img) {
        this.storeName = storeName;
        this.distance = distance;
        this.sales = sales;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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
}

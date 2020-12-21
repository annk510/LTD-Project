package com.example.vongship_android.DTO;

public class Store {
    private String storeId;
    private String storeName;
    private String distance;
    private String sale;
    private String image;

    public Store() {
    }

    public Store(String storeId, String storeName, String distance, String sale, String image) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.distance = distance;
        this.sale = sale;
        this.image = image;
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

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

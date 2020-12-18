package com.example.vongship_android.DTO;

public class ProductPoint {
    private int image;
    private String name;
    private String sale;
    private String point;

    public ProductPoint(int image, String name, String sale, String point) {
        this.image = image;
        this.name = name;
        this.sale = sale;
        this.point = point;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}

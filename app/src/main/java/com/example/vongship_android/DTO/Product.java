package com.example.vongship_android.DTO;

public class Product {

    private String productid;
    private String productname;
    private String price;
    private String description;
    private int img;

    public Product() {
    }

    public Product(String productid, String productname, String price, String description, int img) {
        this.productid = productid;
        this.productname = productname;
        this.price = price;
        this.description = description;
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

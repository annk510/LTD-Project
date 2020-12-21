package com.example.vongship_android.DTO;

import java.io.Serializable;

public class Product implements Serializable {

    private String productid;
    private String productname;
    private String price;
    private String description;
    private String image;
    private String categoryid;
    private String storeid;

    public Product(String productid, String productname, String price, String description, String image, String categoryid, String storeid) {
        this.productid = productid;
        this.productname = productname;
        this.price = price;
        this.description = description;
        this.image = image;
        this.categoryid = categoryid;
        this.storeid = storeid;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public Product() {
    }

    public Product(String productid, String productname, String price, String description, String image) {
        this.productid = productid;
        this.productname = productname;
        this.price = price;
        this.description = description;
        this.image = image;
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

    public String getImg() {
        return image;
    }

    public void setImg(String image) {
        this.image = image;
    }
}

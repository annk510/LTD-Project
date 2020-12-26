package com.example.vongship_android.DTO;

public class Product_order extends Product{
    private String quatity;

    public Product_order(String quatity) {
        super();
        this.quatity = quatity;
    }

    public String getQuatity() {
        return quatity;
    }

    public void setQuatity(String quatity) {
        this.quatity = quatity;
    }
}

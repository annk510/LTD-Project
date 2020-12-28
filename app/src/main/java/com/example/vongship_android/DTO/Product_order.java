package com.example.vongship_android.DTO;

import java.io.Serializable;

public class Product_order extends Product implements Serializable {
    private String quatity;

    public Product_order(String quatity) {
        super();
        this.quatity = quatity;
    }

    public Product_order() {
    }

    public String getQuatity() {
        return quatity;
    }

    public void setQuatity(String quatity) {
        this.quatity = quatity;
    }
}

package com.example.vongship_android.DTO;

public class Categories {

    private String categoryId;
    private String categoryName;
    private int Img;

    public Categories() {
    }

    public Categories(String categoryId, String categoryName, int img) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        Img = img;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }
}

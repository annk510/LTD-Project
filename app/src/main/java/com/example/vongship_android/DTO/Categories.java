package com.example.vongship_android.DTO;

public class Categories {

    private int categoryId;
    private String categoryName;
    private String urlImg;
    private int idImg;

    public Categories() {
    }

//    public Categories(int categoryId, String categoryName, String urlImg, int idImg) {
//        this.categoryId = categoryId;
//        this.categoryName = categoryName;
//        this.urlImg = urlImg;
//        this.idImg = idImg;
//    }

    public Categories(int categoryId, String categoryName, int idImg) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.idImg = idImg;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }
}

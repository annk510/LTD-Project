package com.example.vongship_android.DTO;

public class Comments {
    private int avatar, food;
    private String name, shop, time;
    private String title;

    public Comments(int avatar, int food, String name, String shop, String time, String title) {
        this.avatar = avatar;
        this.food = food;
        this.name = name;
        this.shop = shop;
        this.time = time;
        this.title = title;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

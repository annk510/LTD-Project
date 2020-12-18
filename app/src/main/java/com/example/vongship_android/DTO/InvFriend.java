package com.example.vongship_android.DTO;

public class InvFriend {
    private int imgage;
    private String name;

    public InvFriend(int img, String name) {
        this.imgage = img;
        this.name = name;
    }

    public int getImg() {
        return imgage;
    }

    public void setImg(int img) {
        this.imgage = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


package com.example.vongship_android.DTO;

public class NotificationFrag {
    private String mTitle;
    private String  mDescription;
    private String images;
    private String content;
    private String salaTime;

    public NotificationFrag() {
    }

    public NotificationFrag(String mTitle, String mDescription, String images, String content, String salaTime) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.images = images;
        this.content = content;
        this.salaTime = salaTime;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSalaTime() {
        return salaTime;
    }

    public void setSalaTime(String salaTime) {
        this.salaTime = salaTime;
    }
}

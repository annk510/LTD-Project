package com.example.vongship_android.DTO;

public class NotificationFrag {
    private String mTitle;
    private String  mDescription;
    private String images;

    public NotificationFrag() {
    }

    public NotificationFrag(String mTitle, String mDescription, String images) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.images = images;
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
}

package com.example.vongship_android.DTO;

public class NotificationFrag {
    private String mTitle;
    private String  mDescription;
    private int images;

    public NotificationFrag(String mTitle, String mDescription, int images) {
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

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}

package com.example.vongship_android.DTO;

import java.util.ArrayList;

public class Section {
    private String headerTitle;
    private ArrayList listContent;

    public Section(String headerTitle, ArrayList listContent) {
        this.headerTitle = headerTitle;
        this.listContent = listContent;
    }

    public Section() {
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList getListContent() {
        return listContent;
    }

    public void setListContent(ArrayList listContent) {
        this.listContent = listContent;
    }
}

package com.example.sample_exercise;

public class TabItem {

    String title;
    boolean isSelected;

    public TabItem(String title,boolean isSelected){
        this.title=title;
        this.isSelected=isSelected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

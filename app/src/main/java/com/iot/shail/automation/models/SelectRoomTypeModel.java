package com.iot.shail.automation.models;

public class SelectRoomTypeModel {

    private String item;
    public int icon;


    public SelectRoomTypeModel(int icon,String item) {
        this.icon = icon;
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

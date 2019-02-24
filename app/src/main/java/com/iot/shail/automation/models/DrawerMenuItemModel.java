package com.iot.shail.automation.models;

public class DrawerMenuItemModel {

    private String item;
    public int icon;

    public DrawerMenuItemModel(int icon,String item) {
        this.icon = icon;
        this.item = item;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
package com.iot.shail.automation.models;

public class AddedRoomModel {

    private String roomType;
    private String priority;
    public int icon;

    public AddedRoomModel(String roomType, int icon, String priority) {
        this.roomType = roomType;
        this.icon = icon;
        this.priority = priority;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}

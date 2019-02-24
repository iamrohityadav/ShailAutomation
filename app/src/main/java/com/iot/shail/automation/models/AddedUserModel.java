package com.iot.shail.automation.models;

public class AddedUserModel {

    private String name;
    private String priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public AddedUserModel(String name, String priority) {
        this.name = name;
        this.priority = priority;
    }
}

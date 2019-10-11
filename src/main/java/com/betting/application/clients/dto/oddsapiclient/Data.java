package com.betting.application.clients.dto.oddsapiclient;

public class Data {
    private String key;
    private boolean active;
    private String group;
    private String details;
    private String title;

    public Data() {
    }

    private Data(String key, boolean active, String group, String details, String title) {
        this.key = key;
        this.active = active;
        this.group = group;
        this.details = details;
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public boolean isActive() {
        return active;
    }

    public String getGroup() {
        return group;
    }

    public String getDetails() {
        return details;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Data{" +
                "key='" + key + '\'' +
                ", active=" + active +
                ", group='" + group + '\'' +
                ", details='" + details + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

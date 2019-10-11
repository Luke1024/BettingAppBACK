package com.betting.application.clients.dto.oddsapiclient;

public class AvailableSportResponse {
    private boolean success;
    private Data[] data;

    public AvailableSportResponse() {
    }

    public AvailableSportResponse(boolean success, Data[] data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public Data[] getData() {
        return data;
    }
}


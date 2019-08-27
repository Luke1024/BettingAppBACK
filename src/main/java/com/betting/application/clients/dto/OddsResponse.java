package com.betting.application.clients.dto;

public class OddsResponse {
    private String match_id;
    private String odd_1;
    private String odd_x;
    private String odd_2;

    public OddsResponse(){}

    public OddsResponse(String match_id, String odd_1, String odd_x, String odd_2) {
        this.match_id = match_id;
        this.odd_1 = odd_1;
        this.odd_x = odd_x;
        this.odd_2 = odd_2;
    }

    public String getMatch_id() {
        return match_id;
    }

    public String getOdd_1() {
        return odd_1;
    }

    public String getOdd_x() {
        return odd_x;
    }

    public String getOdd_2() {
        return odd_2;
    }
}

package com.betting.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OddsApiConfig {
    @Value("451245aa3949a09fabff02d98b21ddae")
    private String k;

    @Value("https://api.the-odds-api.com")
    private String baseEndPoint;

    @Value("/v3/sports?apiKey=")
    private String inSeasonSports;

    public String getInSeasonSports() {
        return baseEndPoint + inSeasonSports + k;
    }

    public String getSport(String sport){
        return baseEndPoint + "/v3/odds/?sport=" +
                sport + "&region=uk&apiKey=" + k;
    }
}

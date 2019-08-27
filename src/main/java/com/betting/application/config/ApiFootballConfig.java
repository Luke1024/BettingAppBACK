package com.betting.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ApiFootballConfig {
    @Value("https://apiv2.apifootball.com")
    private String endpoint;

    @Value("/?action=get_events&from=2019-08-25&to=2019-09-26")
    private String events;

    @Value("/?action=get_odds&from=2019-08-26&to=2019-08-30")
    private String eventOdds;

    @Value("&APIkey=f94ab1ef89ff27c4063d7f372343aacb4f1d60bf57fd21d05885828e25be25b8")
    private String key;



    public String getEndpoint() {
        return endpoint;
    }

    public String getEvents() {
        return events;
    }

    public String getEvent(Long id){
        return "/?action=get_events&match_id=" + id;
    }

    public String getMatchOdds(LocalDate start, LocalDate stop) {
        return "?action=get_odds&from=" + start.toString() + "&to=" + stop.toString();
    }

    public String getKey() {
        return key;
    }
}

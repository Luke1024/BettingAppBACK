package com.betting.application.clients;

import com.betting.application.clients.dto.MatchDataResponse;
import com.betting.application.clients.dto.OddsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiFootballClientTest {
    @Autowired
    private ApiFootballClient apiFootballClient;

    @Test
    public void getAvailableBets() {
        OddsResponse[] oddsResponses = apiFootballClient.getAvailableMatches();
        System.out.println(oddsResponses.length);
        OddsResponse response = oddsResponses[0];
        System.out.println(response.getMatch_id() + " " + response.getOdd_1() + " " +
                response.getOdd_x() + " " + response.getOdd_2());
    }

    @Test
    public void matchDataResponse() {
        MatchDataResponse[] response = apiFootballClient.matchDataResponses(227513L);
        System.out.println(response[0].toString());
    }
}
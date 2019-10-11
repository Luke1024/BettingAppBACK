package com.betting.application.clients;

import com.betting.application.clients.dto.apifootballclient.OddsResponse;
import com.betting.application.clients.dto.oddsapiclient.AvailableSportResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OddsApiClientTest {

    @Autowired
    private OddsApiClient oddsApiClient;

    @Test
    public void printResponse(){
        AvailableSportResponse availableSportResponse = oddsApiClient.getAvailableSports();
        Arrays.stream(availableSportResponse.getData()).forEach(d -> System.out.println(d.getKey()));
    }
}
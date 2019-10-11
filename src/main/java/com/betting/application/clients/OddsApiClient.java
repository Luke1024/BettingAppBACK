package com.betting.application.clients;

import com.betting.application.clients.dto.oddsapiclient.AvailableSportResponse;
import com.betting.application.config.OddsApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class OddsApiClient {

    @Autowired
    private OddsApiConfig oddsApiConfig;
    private RestTemplate restTemplate = new RestTemplate();

    public AvailableSportResponse getAvailableSports(){
        URI url = UriComponentsBuilder.fromHttpUrl(oddsApiConfig.getInSeasonSports())
                .build().encode().toUri();

        System.out.println(url);

        return restTemplate.getForObject(url, AvailableSportResponse.class);
    }
}

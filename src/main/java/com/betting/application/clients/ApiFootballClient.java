package com.betting.application.clients;

import com.betting.application.clients.dto.apifootballclient.MatchDataResponse;
import com.betting.application.clients.dto.apifootballclient.OddsResponse;
import com.betting.application.config.ApiFootballConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@Component
public class ApiFootballClient {

    @Autowired
    private ApiFootballConfig apiFootballConfig;

    private RestTemplate restTemplate = new RestTemplate();

    public OddsResponse[] getAvailableMatches(){
        URI url = UriComponentsBuilder.fromHttpUrl(apiFootballConfig.getEndpoint() +
                apiFootballConfig.getMatchOdds(LocalDate.now(), LocalDate.now().plusDays(5)) + apiFootballConfig.getKey())
                .build().encode().toUri();

        System.out.println(url);

        return restTemplate.getForObject(url, OddsResponse[].class);
    }

    public MatchDataResponse[] matchDataResponses(Long matchId){
        URI url = UriComponentsBuilder.fromHttpUrl(apiFootballConfig.getEndpoint() +
                apiFootballConfig.getEvent(matchId) + apiFootballConfig.getKey())
                .build().encode().toUri();

        System.out.println(url);

        return restTemplate.getForObject(url, MatchDataResponse[].class);
    }
}

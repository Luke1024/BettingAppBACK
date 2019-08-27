package com.betting.application.service;

import com.betting.application.clients.ApiFootballClient;
import com.betting.application.clients.dto.MatchDataResponse;
import com.betting.application.clients.dto.MatchOddsDto;
import com.betting.application.clients.dto.OddsResponse;
import com.betting.application.domain.Bet;
import com.betting.application.domain.dto.OddsDto;
import com.betting.application.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BetDownloaderService {
    @Autowired
    private ApiFootballClient apiFootballClient;

    @Autowired
    private BetRepository betRepository;

    public List<Bet> getAvailableBets(){
        return betRepository.findAll();
    }

    public void downloadAvailableBets(){
        OddsResponse[] odds = apiFootballClient.getAvailableMatches();
        List<MatchOddsDto> matchOddsDtos = groupToMatchOddsDto(odds);
        List<MatchOddsDto> matchOddsAverages = computeAverageOddsBasedOnMultipleBrokersData(matchOddsDtos);
        List<Bet> bets = collectMatchDataByMatchId(matchOddsAverages);
        bets.stream().forEach(bet -> betRepository.save(bet));
    }


    private List<MatchOddsDto> groupToMatchOddsDto(OddsResponse[] odds) {

        List<MatchOddsDto> matchOddsDtoList = new ArrayList<>();

        List<Long> matchIds = collectUniqueMatchIds(odds);

        for(Long matchId : matchIds) {
            matchOddsDtoList.add(collectOddsByMatchId(matchId, odds));
        }
        return matchOddsDtoList;
    }


    private List<MatchOddsDto> computeAverageOddsBasedOnMultipleBrokersData(List<MatchOddsDto> matchOddsDtos){
        List<MatchOddsDto> matchAverages = new ArrayList<>();

        for(MatchOddsDto matchOddsDto : matchOddsDtos){
            matchAverages.add(computeSingleMatchAverage(matchOddsDto));
        }
        return matchAverages;
    }

    private MatchOddsDto computeSingleMatchAverage(MatchOddsDto matchOddsDto){
        double odd_1 = 0;
        double odd_x = 0;
        double odd_2 = 0;
        int counter = 0;
        for(OddsDto oddsDto : matchOddsDto.getOddsDtos()){
            odd_1 += oddsDto.getOdd_1();
            odd_x += oddsDto.getOdd_x();
            odd_2 += oddsDto.getOdd_2();
            counter++;
        }
        odd_1 = odd_1/counter;
        odd_x = odd_x/counter;
        odd_2 = odd_2/counter;

        return new MatchOddsDto(matchOddsDto.getMatch_id(),
                new ArrayList<>(Arrays.asList(new OddsDto(odd_1, odd_x, odd_2))));
    }

    private MatchOddsDto collectOddsByMatchId(Long matchId, OddsResponse[] oddsResponses){
        List<OddsDto> odds = new ArrayList<>();

        for(int i = 0; i< oddsResponses.length; i++){
            if(Long.parseLong(oddsResponses[i].getMatch_id())==matchId) {
                double odd_1 = Double.parseDouble(oddsResponses[i].getOdd_1());
                double odd_x = Double.parseDouble(oddsResponses[i].getOdd_x());
                double odd_2 = Double.parseDouble(oddsResponses[i].getOdd_2());
                odds.add(new OddsDto(odd_1, odd_x, odd_2));
            }
        }
        return new MatchOddsDto(matchId, odds);
    }

    private List<Long> collectUniqueMatchIds(OddsResponse[] odds) {
        List<Long> uniqueIds = new ArrayList<>();

        for(OddsResponse oddsResponse : odds){
            Long newId = Long.parseLong(oddsResponse.getMatch_id());

            if(! uniqueIds.contains(newId)){
                uniqueIds.add(newId);
            }
        }
        return uniqueIds;
    }

    public List<Bet> collectMatchDataByMatchId(List<MatchOddsDto> matchOdds) {
        List<Bet> betDtos = new ArrayList<>();

        for (MatchOddsDto matchOddsDto : matchOdds) {

            MatchDataResponse matchDataResponse = apiFootballClient.matchDataResponses(matchOddsDto.getMatch_id())[0];

            betDtos.add(new Bet(Long.parseLong(matchDataResponse.getMatch_id()),
                    Long.parseLong(matchDataResponse.getCountry_id()),
                    Long.parseLong(matchDataResponse.getLeague_id()),
                    matchDataResponse.getCountry_name(),
                    matchDataResponse.getLeague_name(),
                    LocalDateTime.of(LocalDate.parse(matchDataResponse.getMatch_date()), LocalTime.parse(matchDataResponse.getMatch_time())),
                    matchDataResponse.getMatch_hometeam_name(),
                    matchDataResponse.getMatch_awayteam_name(),
                    matchOddsDto.getOddsDtos().get(0),
                    matchDataResponse.getMatch_status()));
        }
        return betDtos;
    }
}

package com.betting.application.service;

import com.betting.application.clients.ApiFootballClient;
import com.betting.application.clients.dto.MatchDataResponse;
import com.betting.application.clients.dto.MatchOddsDto;
import com.betting.application.clients.dto.OddsResponse;
import com.betting.application.domain.SportEvent;
import com.betting.application.domain.dto.OddsDto;
import com.betting.application.repository.SportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SportEventService {
    @Autowired
    private ApiFootballClient apiFootballClient;

    @Autowired
    private SportEventRepository sportEventRepository;

    public Optional<SportEvent> getSportEvent(Long id){
        return sportEventRepository.findById(id);
    }

    public List<SportEvent> getAvailableSportEvents(){
        return sportEventRepository.findAll().stream().filter(sportEvent -> sportEvent.getMatch_status().equals("")).collect(Collectors.toList());
    }

    public void downloadAvailableSportEvents(){
        OddsResponse[] odds = apiFootballClient.getAvailableMatches();
        List<MatchOddsDto> matchOddsDtos = groupToMatchOddsDto(odds);
        List<MatchOddsDto> matchOddsAverages = computeAverageOddsBasedOnMultipleBrokersData(matchOddsDtos);
        List<SportEvent> sportEvents = collectMatchDataByMatchId(matchOddsAverages);
        sportEvents.forEach(sportEvent -> sportEventRepository.save(sportEvent));
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

    public List<SportEvent> collectMatchDataByMatchId(List<MatchOddsDto> matchOdds) {
        List<SportEvent> sportEventDtos = new ArrayList<>();

        for (MatchOddsDto matchOddsDto : matchOdds) {

            MatchDataResponse matchDataResponse = apiFootballClient.matchDataResponses(matchOddsDto.getMatch_id())[0];

            sportEventDtos.add(new SportEvent(Long.parseLong(matchDataResponse.getMatch_id()),
                    Long.parseLong(matchDataResponse.getCountry_id()),
                    Long.parseLong(matchDataResponse.getLeague_id()),
                    matchDataResponse.getCountry_name(),
                    matchDataResponse.getLeague_name(),
                    LocalDateTime.of(LocalDate.parse(matchDataResponse.getMatch_date()), LocalTime.parse(matchDataResponse.getMatch_time())),
                    matchDataResponse.getMatch_hometeam_name(),
                    matchDataResponse.getMatch_awayteam_name(),
                    matchOddsDto.getOddsDtos().get(0).getOdd_1(),
                    matchOddsDto.getOddsDtos().get(0).getOdd_x(),
                    matchOddsDto.getOddsDtos().get(0).getOdd_2(),
                    matchDataResponse.getMatch_status()));
        }
        return sportEventDtos;
    }
}

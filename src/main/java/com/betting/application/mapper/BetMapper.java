package com.betting.application.mapper;

import com.betting.application.domain.Bet;
import com.betting.application.domain.dto.BetDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BetMapper {
    public List<BetDto> mapToBetDtoList(List<Bet> bets){
        return bets.stream().map(bet -> new BetDto(bet.getId(), bet.getMatch_id(), bet.getCountry_id(),
                bet.getLeaque_id(), bet.getCountry_name(), bet.getLeague_name(), bet.getMatch_date_time(),
                bet.getMatch_hometeam_name(), bet.getMatch_awayteam_name(),
                bet.getOdd_1(),bet.getOdd_x(), bet.getOdd_2(), bet.getMatch_status())).collect(Collectors.toList());
    }
}

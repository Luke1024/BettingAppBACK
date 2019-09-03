package com.betting.application.mapper;

import com.betting.application.domain.Bet;
import com.betting.application.domain.dto.BetDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BetMapper {
    public BetDto mapToBetDto(Bet bet){
        return new BetDto(bet.getBetId() ,bet.getUser().getId(),
                bet.getSportEvent().getMatch_id(),
                bet.getAmount(),
                bet.getUserPrediction(),
                bet.getActualResult(),
                bet.getSportEvent().getOdd_1(),
                bet.getSportEvent().getOdd_x(),
                bet.getSportEvent().getOdd_2(),
                bet.getAmoutChangeAfterClosing(),
                bet.getOpen(),
                bet.getSportEvent().getMatch_date_time(),
                bet.getLastEdit());
    }

    public List<BetDto> mapToBetDtoList(List<Bet> bets){
        return bets.stream().map(bet -> new BetDto(bet.getBetId(),
                bet.getUser().getId(),
                bet.getSportEvent().getMatch_id(),
                bet.getAmount(),
                bet.getUserPrediction(),
                bet.getActualResult(),
                bet.getSportEvent().getOdd_1(),
                bet.getSportEvent().getOdd_x(),
                bet.getSportEvent().getOdd_2(),
                bet.getAmoutChangeAfterClosing(),
                bet.getOpen(),
                bet.getSportEvent().getMatch_date_time(),
                bet.getLastEdit())).collect(Collectors.toList());
    }
}

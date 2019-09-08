package com.betting.application.mapper;

import com.betting.application.domain.Bet;
import com.betting.application.domain.SportEvent;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.bet.BetDto;
import com.betting.application.domain.utilities.Result;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.MatcherAssert.assertThat;

public class BetMapperTest {

    private BetDto betDto = new BetDto(1L, 1L, 100L, 50.0, Result.AWAY_WIN,
            null, 2.5, 3.0, 1.5, 150.0, LocalDateTime.now(),
            LocalDateTime.now(), LocalDateTime.now());

    private Bet bet = new Bet(1L, new User(), new SportEvent(), 50.0, Result.AWAY_WIN);

    private List<BetDto> betDtos = new ArrayList<>(Arrays.asList());
    private List<Bet> bets = new ArrayList<>(Arrays.asList(new Bet(1L, new User(), new SportEvent(), 50.0, Result.AWAY_WIN)));

    @Test
    public void mapToBetDto() {
    }

    @Test
    public void mapToBetDtoList() {
    }
}
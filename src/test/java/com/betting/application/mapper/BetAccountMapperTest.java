package com.betting.application.mapper;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.domain.BetAccount;
import com.betting.application.domain.Transaction;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.AccountHistoryPointDto;
import com.betting.application.domain.dto.BetAccountDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BetAccountMapperTest {

    @Autowired
    private BetAccountMapper betAccountMapper;

    private LocalDateTime time = LocalDateTime.of(2019, Month.SEPTEMBER, 8, 18,40);

    private AccountHistoryPointDto accountHistoryPointDto
            = new AccountHistoryPointDto(1L, -100.50, 100.50,
            0.0, time, new BetAccount(), new Transaction());
    private AccountHistoryPoint accountHistoryPoint = new AccountHistoryPoint(1L ,-100.50,
            100.50, 0.0, time, new BetAccount(), new Transaction());

    private BetAccount betAccount = new BetAccount(1L, new User(), 100.50,
            new ArrayList<>(Arrays.asList(accountHistoryPoint)));
    private BetAccountDto betAccountDto = new BetAccountDto(1L, new User(), 100.50,
            new ArrayList<>(Arrays.asList(accountHistoryPointDto)));

    @Test
    public void mapToBetAccountDto() {
        assertThat(betAccountDto, sameBeanAs(betAccountMapper.mapToBetAccountDto(betAccount)));
    }
}
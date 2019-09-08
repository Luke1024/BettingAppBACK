package com.betting.application.mapper;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.domain.BetAccount;
import com.betting.application.domain.Transaction;
import com.betting.application.domain.dto.AccountHistoryPointDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountHistoryPointMapperTest {

    @Autowired
    private AccountHistoryPointMapper accountHistoryPointMapper;

    @Test
    public void mapToAccountHistoryPointList() {
        LocalDateTime time = LocalDateTime.of(2019, Month.SEPTEMBER, 8, 18,40);

        AccountHistoryPointDto accountHistoryPointDto
                = new AccountHistoryPointDto(1L, -100.50, 100.50,
                0.0, time, new BetAccount(), new Transaction());
        AccountHistoryPoint accountHistoryPoint = new AccountHistoryPoint(1L,-100.50, 100.50, 0.0, time, new BetAccount(), new Transaction());

        List<AccountHistoryPointDto> accountHistoryPointDtoList
                = new ArrayList<>(Arrays.asList(accountHistoryPointDto));
        List<AccountHistoryPoint> accountHistoryPoints
                = new ArrayList<>(Arrays.asList(accountHistoryPoint));

        assertThat(accountHistoryPointDtoList,
                sameBeanAs(accountHistoryPointMapper.mapToAccountHistoryPointList(accountHistoryPoints)));
    }
}
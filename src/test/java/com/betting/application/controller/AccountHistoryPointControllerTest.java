package com.betting.application.controller;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.domain.BetAccount;
import com.betting.application.domain.Transaction;
import com.betting.application.domain.dto.AccountHistoryPointDto;
import com.betting.application.mapper.AccountHistoryPointMapper;
import com.betting.application.service.AccountHistoryPointService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountHistoryPointController.class)
public class AccountHistoryPointControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountHistoryPointService accountHistoryPointService;

    @MockBean
    private AccountHistoryPointMapper accountHistoryPointMapper;

    @Test
    public void getAccountHistoryPoints() throws Exception {
        AccountHistoryPointDto accountHistoryPointDto
                = new AccountHistoryPointDto(1L, -100.50, 100.50, 0.0, LocalDateTime.now(), new BetAccount(), new Transaction());
        AccountHistoryPoint accountHistoryPoint = new AccountHistoryPoint(-100.50, 100.50, 0.0, LocalDateTime.now(), new BetAccount(), new Transaction());

        List<AccountHistoryPointDto> accountHistoryPointDtoList
                = new ArrayList<>(Collections.singletonList(accountHistoryPointDto));
        List<AccountHistoryPoint> accountHistoryPoints
                = new ArrayList<>(Collections.singletonList(accountHistoryPoint));

        when(accountHistoryPointService.getUserAccountHistoryPoints(ArgumentMatchers.anyLong())).thenReturn(accountHistoryPoints);
        when(accountHistoryPointMapper.mapToAccountHistoryPointList(ArgumentMatchers.anyList())).thenReturn(accountHistoryPointDtoList);
        mockMvc.perform(get("/betting/accountHistoryPoints/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].pointId", is(1)))
                .andExpect(jsonPath("$[0].accountBalanceChange", is(-100.50)))
                .andExpect(jsonPath("$[0].moneyAmountBeforeChange", is(100.50)))
                .andExpect(jsonPath("$[0].moneyAmountAfterChange", is(0.0)));
    }
}
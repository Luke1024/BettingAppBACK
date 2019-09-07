package com.betting.application.controller;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.domain.BetAccount;
import com.betting.application.domain.Transaction;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.AccountHistoryPointDto;
import com.betting.application.domain.dto.BetAccountDto;
import com.betting.application.mapper.BetAccountMapper;
import com.betting.application.service.BetAccountService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@WebMvcTest(BetAccountController.class)
public class BetAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BetAccountService betAccountService;

    @MockBean
    private BetAccountMapper betAccountMapper;

    @Test
    public void getUserBetAccount() throws Exception {

        AccountHistoryPointDto accountHistoryPointDto
                = new AccountHistoryPointDto(1L, -100.50, 100.50, 0.0, LocalDateTime.now(), new BetAccount(), new Transaction());
        AccountHistoryPoint accountHistoryPoint = new AccountHistoryPoint(-100.50, 100.50, 0.0, LocalDateTime.now(), new BetAccount(), new Transaction());


        BetAccount betAccount = new BetAccount(new User(), 100.50, new ArrayList<>(Arrays.asList(accountHistoryPoint)));
        BetAccountDto betAccountDto = new BetAccountDto(1L, new User(), 100.50, new ArrayList<>(Arrays.asList(accountHistoryPointDto)));

        when(betAccountService.getBetAccount(ArgumentMatchers.anyLong())).thenReturn(betAccount);
        when(betAccountMapper.mapToBetAccountDto(ArgumentMatchers.any(BetAccount.class))).thenReturn(betAccountDto);

        mockMvc.perform(get("/betting/betAccount/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$", hasSize(1)))
                //.andExpect(jsonPath("$[0].id", is(1)))
                //.andExpect(jsonPath("$[0].amount", is(100.50)));
    }
}
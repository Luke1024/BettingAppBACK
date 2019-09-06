package com.betting.application.controller;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.domain.dto.AccountHistoryPointDto;
import com.betting.application.mapper.AccountHistoryPointMapper;
import com.betting.application.service.AccountHistoryPointService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

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
    }
}
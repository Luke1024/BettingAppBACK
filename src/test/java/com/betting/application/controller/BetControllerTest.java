package com.betting.application.controller;

import com.betting.application.domain.Bet;
import com.betting.application.domain.SportEvent;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.bet.BetDto;
import com.betting.application.domain.dto.bet.BetPlacerDto;
import com.betting.application.domain.utilities.Result;
import com.betting.application.mapper.BetMapper;
import com.betting.application.service.BetService;
import com.google.gson.Gson;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@WebMvcTest(BetController.class)
public class BetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BetService betService;

    @MockBean
    private BetMapper betMapper;

    private List<BetDto> betDtos = new ArrayList<>(Collections.singletonList(new BetDto(1L, 1L, 100L, 50.0, Result.AWAY_WIN,
            null, 2.5, 3.0, 1.5, 150.0, LocalDateTime.now()
            , LocalDateTime.now(), LocalDateTime.now())));
    private List<Bet> bets = new ArrayList<>(Collections.singletonList(new Bet(1L, new User(), new SportEvent(), 50.0, Result.AWAY_WIN)));

    private Gson gson = new Gson();
    private String betDtosInJson = gson.toJson(betDtos);
    private String betsInJson = gson.toJson(bets);

    @Test
    public void placeBet() throws Exception {
        BetPlacerDto betPlacerDto = new BetPlacerDto(1L, 100L, 50.0, Result.AWAY_WIN);
        Gson gson = new Gson();
        String betPlacerDtoInJson = gson.toJson(betPlacerDto);

        mockMvc.perform(post("/betting/bets")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(betPlacerDtoInJson))
                .andExpect(status().isOk());

    }

    @Test
    public void getUserArchivedBets() throws Exception {
        when(betService.getUserArchivedBets(ArgumentMatchers.anyLong())).thenReturn(bets);
        when(betMapper.mapToBetDtoList(ArgumentMatchers.anyListOf(Bet.class))).thenReturn(betDtos);

        mockMvc.perform(get("/betting/bets/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(betDtosInJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].betId", is(1)))
                .andExpect(jsonPath("$[0].userId",is(1)))
                .andExpect(jsonPath("$[0].matchId",is(100)))
                .andExpect(jsonPath("$[0].amount", is(50.0)))
                .andExpect(jsonPath("$[0].odd_1", is(2.5)))
                .andExpect(jsonPath("$[0].odd_x", is(3.0)))
                .andExpect(jsonPath("$[0].odd_2", is(1.5)))
                .andExpect(jsonPath("$[0].amoutChangeAfterClosing", is(150.0)));
    }

    @Test
    public void getUserBetsAvailableForEdition() throws Exception {
        when(betService.getUserArchivedBets(ArgumentMatchers.anyLong())).thenReturn(bets);
        when(betMapper.mapToBetDtoList(ArgumentMatchers.anyListOf(Bet.class))).thenReturn(betDtos);

        mockMvc.perform(get("/betting/betsEdit/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(betDtosInJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].betId", is(1)))
                .andExpect(jsonPath("$[0].userId",is(1)))
                .andExpect(jsonPath("$[0].matchId",is(100)))
                .andExpect(jsonPath("$[0].amount", is(50.0)))
                .andExpect(jsonPath("$[0].odd_1", is(2.5)))
                .andExpect(jsonPath("$[0].odd_x", is(3.0)))
                .andExpect(jsonPath("$[0].odd_2", is(1.5)))
                .andExpect(jsonPath("$[0].amoutChangeAfterClosing", is(150.0)));
    }

    @Test
    public void getUserBets() throws Exception {
        when(betService.getUserArchivedBets(ArgumentMatchers.anyLong())).thenReturn(bets);
        when(betMapper.mapToBetDtoList(ArgumentMatchers.anyListOf(Bet.class))).thenReturn(betDtos);

        mockMvc.perform(get("/betting/betsAll/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(betDtosInJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].betId", is(1)))
                .andExpect(jsonPath("$[0].userId",is(1)))
                .andExpect(jsonPath("$[0].matchId",is(100)))
                .andExpect(jsonPath("$[0].amount", is(50.0)))
                .andExpect(jsonPath("$[0].odd_1", is(2.5)))
                .andExpect(jsonPath("$[0].odd_x", is(3.0)))
                .andExpect(jsonPath("$[0].odd_2", is(1.5)))
                .andExpect(jsonPath("$[0].amoutChangeAfterClosing", is(150.0)));
    }

    @Test
    public void unarchiveBets() throws Exception {
        mockMvc.perform(delete("/betting/bets/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
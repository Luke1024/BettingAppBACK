package com.betting.application.controller;

import com.betting.application.domain.Bet;
import com.betting.application.domain.SportEvent;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.SportEventDto;
import com.betting.application.domain.utilities.Result;
import com.betting.application.mapper.SportEventMapper;
import com.betting.application.service.SportEventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@WebMvcTest(SportEventController.class)
public class SportEventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SportEventMapper sportEventMapper;

    @MockBean
    private SportEventService sportEventService;

    @Test
    public void getHotBets() throws Exception {
        SportEvent sportEvent =
                new SportEvent(1L, 2L, 3L, "countryName",
                        "leagueName", LocalDateTime.now(), "hometeam", "awayteam",
                        1.5, 2.5, 3.5, "");
        List<SportEvent> sportEvents = new ArrayList<>(Arrays.asList(sportEvent));

        SportEventDto sportEventDto =
                new SportEventDto(1L, 2L, 3L, "countryName",
                        "leagueName", LocalDateTime.now(), "hometeam",
                        "awayteam", 1.5, 2.5, 3.5, "");
        List<SportEventDto> sportEventDtos = new ArrayList<>(Arrays.asList(sportEventDto));

        when(sportEventService.getAvailableSportEvents()).thenReturn(sportEvents);
        when(sportEventMapper.mapToBetDtoList(ArgumentMatchers.anyListOf(SportEvent.class))).thenReturn(sportEventDtos);

        mockMvc.perform(get("/betting/sportEvents")
                .contentType(APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].match_id", is(1)))
                .andExpect(jsonPath("$[0].country_id", is(2)))
                .andExpect(jsonPath("$[0].league_id", is(3)))
                .andExpect(jsonPath("$[0].country_name", is("countryName")))
                .andExpect(jsonPath("$[0].league_name", is("leagueName")))
                .andExpect(jsonPath("$[0].match_hometeam_name", is("hometeam")))
                .andExpect(jsonPath("$[0].match_awayteam_name", is("awayteam")))
                .andExpect(jsonPath("$[0].odd_1", is(1.5)))
                .andExpect(jsonPath("$[0].odd_x", is(2.5)))
                .andExpect(jsonPath("$[0].odd_2", is(3.5)))
                .andExpect(jsonPath("$[0].match_status", is("")));

    }
}
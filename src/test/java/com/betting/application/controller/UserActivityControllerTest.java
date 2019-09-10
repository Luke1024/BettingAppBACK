package com.betting.application.controller;

import com.betting.application.domain.User;
import com.betting.application.domain.UserActivity;
import com.betting.application.domain.dto.UserActivityDto;
import com.betting.application.mapper.UserActivityMapper;
import com.betting.application.service.UserActivityService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@WebMvcTest(UserActivityController.class)
public class UserActivityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserActivityService userActivityService;

    @MockBean
    private UserActivityMapper userActivityMapper;

    @Test
    public void getUserActivity() throws Exception {
        UserActivity userActivity = new UserActivity(1L, new User(), "enter dashboard", LocalDateTime.now());
        List<UserActivity> userActivities = new ArrayList<>(Collections.singletonList(userActivity));

        UserActivityDto userActivityDto = new UserActivityDto(1L, new User(), "enter dashboard", LocalDateTime.now());
        List<UserActivityDto> userActivityDtos = new ArrayList<>(Arrays.asList(userActivityDto));

        when(userActivityService.getUserActivity(ArgumentMatchers.anyLong())).thenReturn(userActivities);
        when(userActivityMapper.mapToUserActivityDtoList(ArgumentMatchers.anyListOf(UserActivity.class))).thenReturn(userActivityDtos);

        mockMvc.perform((get("/betting/activity/1"))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].activityType", is("enter dashboard")));
    }
}
package com.betting.application.mapper;

import com.betting.application.domain.User;
import com.betting.application.domain.UserActivity;
import com.betting.application.domain.dto.UserActivityDto;
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
public class UserActivityMapperTest {

    @Autowired
    private UserActivityMapper userActivityMapper;

    @Test
    public void mapToUserActivityDtoList() {
        LocalDateTime time = LocalDateTime.of(2019, Month.SEPTEMBER, 8, 18,40);

        UserActivity userActivity = new UserActivity(1L, new User(), "enter dashboard", time);
        List<UserActivity> userActivities = new ArrayList<>(Arrays.asList(userActivity));

        UserActivityDto userActivityDto = new UserActivityDto(1L, new User(), "enter dashboard", time);
        List<UserActivityDto> userActivityDtos = new ArrayList<>(Arrays.asList(userActivityDto));

        assertThat(userActivityDtos, sameBeanAs(userActivityMapper.mapToUserActivityDtoList(userActivities)));
    }
}
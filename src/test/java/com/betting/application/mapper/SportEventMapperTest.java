package com.betting.application.mapper;

import com.betting.application.domain.SportEvent;
import com.betting.application.domain.dto.SportEventDto;
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
public class SportEventMapperTest {

    @Autowired
    private SportEventMapper sportEventMapper;

    @Test
    public void mapToBetDtoList() {
        LocalDateTime time = LocalDateTime.of(2019, Month.SEPTEMBER, 8, 18,40);

        SportEvent sportEvent =
                new SportEvent(1L, 2L, 3L, "countryName",
                        "leagueName", time, "hometeam", "awayteam",
                        1.5, 2.5, 3.5, "");
        List<SportEvent> sportEvents = new ArrayList<>(Arrays.asList(sportEvent));

        SportEventDto sportEventDto =
                new SportEventDto(1L, 2L, 3L, "countryName",
                        "leagueName", time, "hometeam",
                        "awayteam", 1.5, 2.5, 3.5, "");
        List<SportEventDto> sportEventDtos = new ArrayList<>(Arrays.asList(sportEventDto));

        assertThat(sportEventDtos, sameBeanAs(sportEventMapper.mapToBetDtoList(sportEvents)));
    }
}
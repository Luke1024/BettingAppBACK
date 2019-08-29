package com.betting.application.mapper;

import com.betting.application.domain.SportEvent;
import com.betting.application.domain.dto.SportEventDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SportEventMapper {
    public List<SportEventDto> mapToBetDtoList(List<SportEvent> sportEvents){
        return sportEvents.stream().map(sportEvent -> new SportEventDto(sportEvent.getMatch_id(), sportEvent.getCountry_id(),
                sportEvent.getLeaque_id(), sportEvent.getCountry_name(), sportEvent.getLeague_name(), sportEvent.getMatch_date_time(),
                sportEvent.getMatch_hometeam_name(), sportEvent.getMatch_awayteam_name(),
                sportEvent.getOdd_1(), sportEvent.getOdd_x(), sportEvent.getOdd_2(), sportEvent.getMatch_status())).collect(Collectors.toList());
    }
}

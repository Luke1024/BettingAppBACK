package com.betting.application.controller;

import com.betting.application.domain.dto.SportEventDto;
import com.betting.application.mapper.SportEventMapper;
import com.betting.application.service.SportEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class SportEventController {
    private Logger LOGGER = LoggerFactory.getLogger(SportEventController.class);

    @Autowired
    private SportEventService sportEventService;

    @Autowired
    private SportEventMapper sportEventMapper;

    @GetMapping(value = "/getAvailableSportEvents")
    public List<SportEventDto> getHotBets(){
        return sportEventMapper.mapToBetDtoList(sportEventService.getAvailableSportEvents());
    }
}

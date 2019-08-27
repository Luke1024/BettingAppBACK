package com.betting.application.controller;

import com.betting.application.domain.dto.BetDto;
import com.betting.application.mapper.BetMapper;
import com.betting.application.service.BetDownloaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class BettingController {
    private Logger LOGGER = LoggerFactory.getLogger(BettingController.class);

    @Autowired
    private BetDownloaderService betDownloaderService;

    @Autowired
    private BetMapper betMapper;

    @GetMapping(value = "/getAvailableBets")
    public List<BetDto> getHotBets(){
        return betMapper.mapToBetDtoList(betDownloaderService.getAvailableBets());
    }
}

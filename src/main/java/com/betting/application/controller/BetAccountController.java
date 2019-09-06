package com.betting.application.controller;

import com.betting.application.domain.dto.BetAccountDto;
import com.betting.application.mapper.BetAccountMapper;
import com.betting.application.service.BetAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class BetAccountController {

    @Autowired
    private BetAccountService betAccountService;

    @Autowired
    private BetAccountMapper betAccountMapper;

    @GetMapping(value = "/betAccount")
    public BetAccountDto getUserBetAccount(Long userId){
        return betAccountMapper.mapToBetAccountDto(betAccountService.getBetAccount(userId));
    }
}

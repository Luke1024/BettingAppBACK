package com.betting.application.controller;

import com.betting.application.domain.dto.BetAccountDto;
import com.betting.application.mapper.BetAccountMapper;
import com.betting.application.service.BetAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class BetAccountController {

    @Autowired
    private BetAccountService betAccountService;

    @Autowired
    private BetAccountMapper betAccountMapper;

    @GetMapping(value = "/betAccount/{userId}")
    public BetAccountDto getUserBetAccount(@PathVariable Long userId){
        return betAccountMapper.mapToBetAccountDto(betAccountService.getBetAccount(userId));
    }
}

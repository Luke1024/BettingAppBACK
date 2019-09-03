package com.betting.application.controller;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.mapper.AccountHistoryPointMapper;
import com.betting.application.service.AccountHistoryPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class AccountHistoryPointController {

    @Autowired
    private AccountHistoryPointService accountHistoryPointService;

    @Autowired
    private AccountHistoryPointMapper accountHistoryPointMapper;

    @GetMapping(value = "/accountHistoryPoints")
    public void getHistoryPoints(@PathVariable Long userId){
        accountHistoryPointMapper.mapToAccountHistoryPointList(accountHistoryPointService.getUserAccountHistoryPoints(userId));
    }
}

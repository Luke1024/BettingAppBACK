package com.betting.application.controller;

import com.betting.application.domain.dto.AccountHistoryPointDto;
import com.betting.application.mapper.AccountHistoryPointMapper;
import com.betting.application.service.AccountHistoryPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class AccountHistoryPointController {

    @Autowired
    private AccountHistoryPointService accountHistoryPointService;

    @Autowired
    private AccountHistoryPointMapper accountHistoryPointMapper;

    @GetMapping(value = "/accountHistoryPoints")
    public List<AccountHistoryPointDto> getHistoryPoints(@PathVariable Long userId){
        return accountHistoryPointMapper.mapToAccountHistoryPointList(
                accountHistoryPointService.getUserAccountHistoryPoints(userId));
    }
}

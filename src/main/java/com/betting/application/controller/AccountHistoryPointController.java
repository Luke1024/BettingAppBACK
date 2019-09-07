package com.betting.application.controller;

import com.betting.application.controller.error.UserNotFoundException;
import com.betting.application.domain.dto.AccountHistoryPointDto;
import com.betting.application.mapper.AccountHistoryPointMapper;
import com.betting.application.service.AccountHistoryPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = UserNotFoundException.class)
    public String handleHistoryPointsException(UserNotFoundException e){
        return e.getMessage();
    }

    @GetMapping(value = "/accountHistoryPoints/{userId}")
    public List<AccountHistoryPointDto> getAccountHistoryPoints(@PathVariable Long userId) throws UserNotFoundException {
        return accountHistoryPointMapper.mapToAccountHistoryPointList(
                accountHistoryPointService.getUserAccountHistoryPoints(userId));
    }
}

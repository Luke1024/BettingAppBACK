package com.betting.application.controller;

import com.betting.application.domain.dto.bet.BetDto;
import com.betting.application.domain.dto.bet.BetPlacerDto;
import com.betting.application.mapper.BetMapper;
import com.betting.application.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/betting")
public class BetController {

    @Autowired
    private BetService betService;

    @Autowired
    private BetMapper betMapper;

    @PostMapping(value = "/placeBet", consumes = APPLICATION_JSON_VALUE)
    public void placeBet(@RequestBody BetPlacerDto betPlacerDto){
        betService.saveBet(betPlacerDto);
    }

    @GetMapping(value = "/getUserArchivedBets")
    public List<BetDto> getUserArchivedBets(@PathVariable Long userId){
        return betMapper.mapToBetDtoList(betService.getUserArchivedBets(userId));
    }

    @GetMapping(value = "/getUserBetsAvailableForEdition")
    public List<BetDto> getUserBetsAvailableForEdition(@PathVariable Long userId){
        return betMapper.mapToBetDtoList(betService.getUserBetsAvailableForEdition(userId));
    }

    @GetMapping(value = "/getUserBets")
    public List<BetDto> getUserBets(@PathVariable Long userId){
        return betMapper.mapToBetDtoList(betService.getUserBets(userId));
    }

    @DeleteMapping(value = "/unarchiveBets")
    public void unarchiveBets(@PathVariable Long betId){
        betService.unarchiveBets(betId);
    }

    @DeleteMapping(value = "/deleteBets")
    public void deleteBets(@PathVariable Long betId){
        betService.deleteBets(betId);
    }
}

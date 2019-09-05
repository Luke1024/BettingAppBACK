package com.betting.application.controller;

import com.betting.application.domain.dto.bankaccountpersonaldata.BankAccountPersonalDataDto;
import com.betting.application.domain.dto.bankaccountpersonaldata.PersonalDataCreatorDto;
import com.betting.application.mapper.PersonalDataMapper;
import com.betting.application.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class BankAccountPersonalDataController {

    @Autowired
    private PersonalDataService personalDataService;

    @Autowired
    private PersonalDataMapper personalDataMapper;

    @GetMapping(value="/userBankAccountPersonalData")
    public BankAccountPersonalDataDto getBankAccountPersonalData(@PathVariable Long accountId){
        return personalDataMapper.mapToBankAccountPersonalDataDto(
                personalDataService.getUserBankAccountPersonalData(accountId));
    }

    public void createBankAccountPersonalData(PersonalDataCreatorDto personalDataCreatorDto){
        personalDataService.createPersonalData(personalDataCreatorDto);
    }

    public void updateBankAccountPersonalData(PersonalDataCreatorDto personalDataCreatorDto){
        personalDataService.updatePersonalData(personalDataCreatorDto);
    }
}

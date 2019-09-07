package com.betting.application.controller;

import com.betting.application.domain.dto.bankaccountpersonaldata.PersonalDataDto;
import com.betting.application.domain.dto.bankaccountpersonaldata.PersonalDataCreatorDto;
import com.betting.application.mapper.PersonalDataMapper;
import com.betting.application.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class PersonalDataController {

    @Autowired
    private PersonalDataService personalDataService;

    @Autowired
    private PersonalDataMapper personalDataMapper;

    @GetMapping(value="/personalData/{accountId}")
    public PersonalDataDto getBankAccountPersonalData(@PathVariable Long accountId){
        return personalDataMapper.mapToBankAccountPersonalDataDto(
                personalDataService.getUserBankAccountPersonalData(accountId));
    }

    @PostMapping(value="/personalData", consumes = APPLICATION_JSON_VALUE)
    public void createBankAccountPersonalData(PersonalDataCreatorDto personalDataCreatorDto){
        personalDataService.createPersonalData(personalDataCreatorDto);
    }

    @PutMapping(value="/personalData", consumes = APPLICATION_JSON_VALUE)
    public void updateBankAccountPersonalData(PersonalDataCreatorDto personalDataCreatorDto){
        personalDataService.updatePersonalData(personalDataCreatorDto);
    }
}

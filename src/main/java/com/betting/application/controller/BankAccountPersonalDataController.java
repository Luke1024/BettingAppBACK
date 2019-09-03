package com.betting.application.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class BankAccountPersonalDataController {

    public BankAccountPersonalDataDto getBankAccountPersonalData(PersonalDataRequestDto personalDataRequestDto){

    }

    public void createBankAccountPersonalData(PersonalDataCreatorDto){

    }

    public void updateBankAccountPersonalData(PersonalDataUpdaterDto){

    }
}

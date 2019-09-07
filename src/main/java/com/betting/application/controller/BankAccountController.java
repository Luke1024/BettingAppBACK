package com.betting.application.controller;

import com.betting.application.domain.dto.bankaccount.BankAccountCreationDto;
import com.betting.application.domain.dto.bankaccount.BankAccountDto;
import com.betting.application.domain.dto.bankaccount.BankAccountUpdaterDto;
import com.betting.application.mapper.BankAccountMapper;
import com.betting.application.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private BankAccountMapper bankAccountMapper;

    @GetMapping(value = "/userBankAccount/{userId}")
    public List<BankAccountDto> getUserBankAccountController(@PathVariable Long userId){
        return bankAccountMapper.mapToBankAccountDtoList(bankAccountService.getUserBankAccounts(userId));
    }

    @PostMapping(value = "/userBankAccount", consumes = APPLICATION_JSON_VALUE)
    public void createUserBankAccount(@RequestBody BankAccountCreationDto bankAccountCreationDto) {
        bankAccountService.createBankAccount(bankAccountCreationDto);
    }

    @PutMapping(value = "/userBankAccount", consumes = APPLICATION_JSON_VALUE)
    public void updateUserBankAccount(@RequestBody BankAccountUpdaterDto bankAccountUpdaterDto) {
        bankAccountService.updateBankAccount(bankAccountUpdaterDto);
    }
}

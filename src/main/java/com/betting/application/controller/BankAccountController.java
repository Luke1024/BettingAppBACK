package com.betting.application.controller;

import com.betting.application.domain.BankAccount;
import com.betting.application.domain.dto.BankAccountDto;
import com.betting.application.mapper.BankAccountMapper;
import com.betting.application.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private BankAccountMapper bankAccountMapper;

    @GetMapping(value = "/getUserBankAccount")
    public List<BankAccountDto> getUserBankAccountController(@PathVariable Long userId){
        return bankAccountMapper.mapToBankAccountDtoList(bankAccountService.getUserBankAccounts(userId));
    }
}

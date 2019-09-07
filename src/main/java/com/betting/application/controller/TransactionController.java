package com.betting.application.controller;

import com.betting.application.domain.dto.transaction.TransactionCreatorDto;
import com.betting.application.domain.dto.transaction.TransactionDto;
import com.betting.application.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/betting")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/userTransactions/{userId}")
    public List<TransactionDto> getUserTransactions(@PathVariable Long userId){
        return transactionService.getUserTransactions(userId);
    }

    @PostMapping(value = "/userTransactions")
    public void createTransaction(@RequestBody TransactionCreatorDto transactionCreatorDto){
        transactionService.createUserTransaction(transactionCreatorDto);
    }
}

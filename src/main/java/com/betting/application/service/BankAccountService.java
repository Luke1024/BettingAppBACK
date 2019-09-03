package com.betting.application.service;

import com.betting.application.domain.BankAccount;
import com.betting.application.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private UserService userService;

    public List<BankAccount> getUserBankAccounts(Long userId){
        Optional<User> user = userService.getUser(userId);
        List<BankAccount> bankAccounts = new ArrayList<>();
        if(user.isPresent()){
            bankAccounts = user.get().getBankAccounts();
        } else {}
        return bankAccounts;
    }
}

package com.betting.application.service;

import com.betting.application.domain.BankAccount;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.bankaccount.BankAccountCreationDto;
import com.betting.application.domain.dto.bankaccount.BankAccountUpdaterDto;
import com.betting.application.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private UserService userService;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public Optional<BankAccount> getBankAccount(Long accountId) {
        return bankAccountRepository.findById(accountId);
    }

    public List<BankAccount> getUserBankAccounts(Long userId){
        Optional<User> user = userService.getUser(userId);
        List<BankAccount> bankAccounts = new ArrayList<>();
        if(user.isPresent()){
            bankAccounts = user.get().getBankAccounts();
        } else {}
        return bankAccounts;
    }

    public void createBankAccount(BankAccountCreationDto bankAccountCreationDto) {
        Optional<User> user = userService.getUser(bankAccountCreationDto.getUserId());
        if(user.isPresent()){
            user.get().getBankAccounts().add(new BankAccount(bankAccountCreationDto.getBankName(),
                    bankAccountCreationDto.getBankNumber(),
                    user.get()));
        } else {}
    }

    public void updateBankAccount(BankAccountUpdaterDto bankAccountUpdaterDto){
        Optional<User> user = userService.getUser(bankAccountUpdaterDto.getUserId());
        if(user.isPresent()){
            user.get().getBankAccounts().add(new BankAccount(bankAccountUpdaterDto.getBankName(),
                    bankAccountUpdaterDto.getBankNumber(),
                    user.get()));
        } else {}
    }
}

package com.betting.application.domain.dto;

import com.betting.application.domain.BankAccountPersonalData;
import com.betting.application.domain.Transaction;
import com.betting.application.domain.User;

import java.util.List;

public class BankAccountDto {
    private Long bankAccountId;
    private BankAccountPersonalData bankAccountPersonalData;
    private String bankName;
    private String bankNumber;
    private User user;
    private List<Transaction> transactionList;

    public BankAccountDto(Long bankAccountId, BankAccountPersonalData bankAccountPersonalData, String bankName, String bankNumber, User user, List<Transaction> transactionList) {
        this.bankAccountId = bankAccountId;
        this.bankAccountPersonalData = bankAccountPersonalData;
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.user = user;
        this.transactionList = transactionList;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public BankAccountPersonalData getBankAccountPersonalData() {
        return bankAccountPersonalData;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public User getUser() {
        return user;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}

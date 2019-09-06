package com.betting.application.domain.dto.bankaccount;

import com.betting.application.domain.PersonalData;
import com.betting.application.domain.Transaction;
import com.betting.application.domain.User;

import java.util.List;

public class BankAccountDto {
    private Long bankAccountId;
    private PersonalData personalData;
    private String bankName;
    private String bankNumber;
    private User user;
    private List<Transaction> transactionList;

    public BankAccountDto(Long bankAccountId, PersonalData personalData, String bankName, String bankNumber, User user, List<Transaction> transactionList) {
        this.bankAccountId = bankAccountId;
        this.personalData = personalData;
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.user = user;
        this.transactionList = transactionList;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public PersonalData getPersonalData() {
        return personalData;
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

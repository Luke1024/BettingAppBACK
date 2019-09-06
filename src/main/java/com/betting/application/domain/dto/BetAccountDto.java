package com.betting.application.domain.dto;

import com.betting.application.domain.User;

import java.util.List;

public class BetAccountDto {
    private Long id;
    private User user;
    private double amount;
    private List<AccountHistoryPointDto> accountHistoryPointList;

    public BetAccountDto(Long id, User user, double amount, List<AccountHistoryPointDto> accountHistoryPointList) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.accountHistoryPointList = accountHistoryPointList;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public List<AccountHistoryPointDto> getAccountHistoryPointList() {
        return accountHistoryPointList;
    }
}

package com.betting.application.domain.dto;

import com.betting.application.domain.BetAccount;
import com.betting.application.domain.Transaction;

import java.time.LocalDateTime;

public class AccountHistoryPointDto {
    private Long pointId;
    private double accountBalanceChange;
    private double moneyAmountBeforeChange;
    private double moneyAmountAfterChange;
    private LocalDateTime accountChangeTime;
    private BetAccount betAccount;
    private Transaction transaction;

    public AccountHistoryPointDto(Long pointId, double accountBalanceChange, double moneyAmountBeforeChange, double moneyAmountAfterChange, LocalDateTime accountChangeTime, BetAccount betAccount, Transaction transaction) {
        this.pointId = pointId;
        this.accountBalanceChange = accountBalanceChange;
        this.moneyAmountBeforeChange = moneyAmountBeforeChange;
        this.moneyAmountAfterChange = moneyAmountAfterChange;
        this.accountChangeTime = accountChangeTime;
        this.betAccount = betAccount;
        this.transaction = transaction;
    }

    public Long getPointId() {
        return pointId;
    }

    public double getAccountBalanceChange() {
        return accountBalanceChange;
    }

    public double getMoneyAmountBeforeChange() {
        return moneyAmountBeforeChange;
    }

    public double getMoneyAmountAfterChange() {
        return moneyAmountAfterChange;
    }

    public LocalDateTime getAccountChangeTime() {
        return accountChangeTime;
    }

    public BetAccount getBetAccount() {
        return betAccount;
    }

    public Transaction getTransaction() {
        return transaction;
    }
}

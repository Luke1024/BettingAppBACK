package com.betting.application.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AccountHistoryPoint {
    @Id
    @GeneratedValue
    private Long pointId;
    private double accountBalanceChange;
    private double moneyAmountBeforeChange;
    private double moneyAmountAfterChange;
    private LocalDateTime accountChangeTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BET_ACCOUNT_ID")
    private BetAccount betAccount;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Transaction transaction;

    public AccountHistoryPoint() {}

    public AccountHistoryPoint(double accountBalanceChange, double moneyAmountBeforeChange, double moneyAmountAfterChange, LocalDateTime accountChangeTime, BetAccount betAccount, Transaction transaction) {
        this.accountBalanceChange = accountBalanceChange;
        this.moneyAmountBeforeChange = moneyAmountBeforeChange;
        this.moneyAmountAfterChange = moneyAmountAfterChange;
        this.accountChangeTime = accountChangeTime;
        this.betAccount = betAccount;
        this.transaction = transaction;
    }

    public AccountHistoryPoint(Long pointId, double accountBalanceChange, double moneyAmountBeforeChange, double moneyAmountAfterChange, LocalDateTime accountChangeTime, BetAccount betAccount, Transaction transaction) {
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




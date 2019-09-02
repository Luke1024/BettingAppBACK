package com.betting.application.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AccountHistoryPoint {
    @Id
    @GeneratedValue
    private Long pointId;
    private double accountBalanceChange;
    private double money_amount_before_change;
    private double money_amount_after_change;
    private LocalDateTime account_change_time;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BET_ACCOUNT_ID")
    private BetAccount betAccount;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Transaction transaction;

    public AccountHistoryPoint() {}

    public AccountHistoryPoint(double accountBalanceChange, double money_amount_before_change, double money_amount_after_change, LocalDateTime account_change_time, BetAccount betAccount, Transaction transaction) {
        this.accountBalanceChange = accountBalanceChange;
        this.money_amount_before_change = money_amount_before_change;
        this.money_amount_after_change = money_amount_after_change;
        this.account_change_time = account_change_time;
        this.betAccount = betAccount;
        this.transaction = transaction;
    }

    public Long getPointId() {
        return pointId;
    }

    public double getAccountBalanceChange() {
        return accountBalanceChange;
    }

    public double getMoney_amount_before_change() {
        return money_amount_before_change;
    }

    public double getMoney_amount_after_change() {
        return money_amount_after_change;
    }

    public LocalDateTime getAccount_change_time() {
        return account_change_time;
    }

    public BetAccount getBetAccount() {
        return betAccount;
    }

    public Transaction getTransaction() {
        return transaction;
    }
}




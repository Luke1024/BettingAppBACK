package com.betting.application.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
public class BetAccount {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
    private double amount;
    @OneToMany(targetEntity = AccountHistoryPoint.class,
            mappedBy = "betAccount",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<AccountHistoryPoint> accountHistoryPointList;

    public BetAccount() {}

    public BetAccount(User user, double amount, List<AccountHistoryPoint> accountHistoryPointList) {
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

    public List<AccountHistoryPoint> getAccountHistoryPointList() {
        return accountHistoryPointList;
    }
}

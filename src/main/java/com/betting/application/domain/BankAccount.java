package com.betting.application.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class BankAccount {
    @Id
    private Long bankAccountId;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BankAccountPersonalData bankAccountPersonalData;
    private String bankName;
    private String bankNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
    @OneToMany(
            targetEntity = Transaction.class,
            mappedBy = "bankAccount",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Transaction> transactions;

    public BankAccount() {}

    public BankAccount(Long bankAccountId, BankAccountPersonalData bankAccountPersonalData, String bankName, String bankNumber, User user, List<Transaction> transactions) {
        this.bankAccountId = bankAccountId;
        this.bankAccountPersonalData = bankAccountPersonalData;
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.user = user;
        this.transactions = transactions;
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

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

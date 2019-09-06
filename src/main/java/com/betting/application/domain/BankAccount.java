package com.betting.application.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue
    private Long bankAccountId;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PersonalData personalData;
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

    public BankAccount(String bankName, String bankNumber, User user) {
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.user = user;
    }

    public BankAccount(Long bankAccountId, String bankName, String bankNumber, User user) {
        this.bankAccountId = bankAccountId;
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.user = user;
    }

    public BankAccount(Long bankAccountId, PersonalData personalData, String bankName, String bankNumber, User user, List<Transaction> transactions) {
        this.bankAccountId = bankAccountId;
        this.personalData = personalData;
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.user = user;
        this.transactions = transactions;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
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

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

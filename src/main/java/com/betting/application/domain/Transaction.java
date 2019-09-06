package com.betting.application.domain;

import com.betting.application.domain.utilities.PaymentDirection;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long transactionId;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AccountHistoryPoint accountHistoryPoint;
    private PaymentDirection paymentDirection;
    private double amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BANK_ACCOUNT_ID")
    private BankAccount bankAccount;

    public Transaction() {}

    public Transaction(PaymentDirection paymentDirection, double amount, BankAccount bankAccount) {
        this.paymentDirection = paymentDirection;
        this.amount = amount;
        this.bankAccount = bankAccount;
    }

    public Transaction(Long transactionId, AccountHistoryPoint accountHistoryPoint, PaymentDirection paymentDirection, double amount, BankAccount bankAccount) {
        this.transactionId = transactionId;
        this.accountHistoryPoint = accountHistoryPoint;
        this.paymentDirection = paymentDirection;
        this.amount = amount;
        this.bankAccount = bankAccount;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public AccountHistoryPoint getAccountHistoryPoint() {
        return accountHistoryPoint;
    }

    public PaymentDirection getPaymentDirection() {
        return paymentDirection;
    }

    public double getAmount() {
        return amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}

package com.betting.application.domain.dto.transaction;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.domain.BankAccount;
import com.betting.application.domain.utilities.PaymentDirection;

public class TransactionDto {
    private Long transactionId;
    private AccountHistoryPoint accountHistoryPoint;
    private PaymentDirection paymentDirection;
    private double amount;
    private BankAccount bankAccount;

    public TransactionDto(Long transactionId, AccountHistoryPoint accountHistoryPoint, PaymentDirection paymentDirection, double amount, BankAccount bankAccount) {
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

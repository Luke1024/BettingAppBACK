package com.betting.application.domain.dto.transaction;

import com.betting.application.domain.utilities.PaymentDirection;

public class TransactionCreatorDto {
    private PaymentDirection paymentDirection;
    private double amount;
    private Long bankAccountId;

    public TransactionCreatorDto(PaymentDirection paymentDirection, double amount, Long bankAccountId) {
        this.paymentDirection = paymentDirection;
        this.amount = amount;
        this.bankAccountId = bankAccountId;
    }

    public PaymentDirection getPaymentDirection() {
        return paymentDirection;
    }

    public double getAmount() {
        return amount;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }
}

package com.betting.application.domain.dto.bankaccount;

public class BankAccountUpdaterDto {
    private Long bankAccountId;
    private String bankName;
    private String bankNumber;
    private Long userId;

    public BankAccountUpdaterDto(Long bankAccountId, String bankName, String bankNumber, Long userId) {
        this.bankAccountId = bankAccountId;
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.userId = userId;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public Long getUserId() {
        return userId;
    }
}

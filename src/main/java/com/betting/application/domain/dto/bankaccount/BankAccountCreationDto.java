package com.betting.application.domain.dto.bankaccount;

public class BankAccountCreationDto {
    private String bankName;
    private String bankNumber;
    private Long userId;

    public BankAccountCreationDto() {}

    public BankAccountCreationDto(String bankName, String bankNumber, Long userId) {
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.userId = userId;
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

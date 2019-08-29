package com.betting.application.domain.dto;

import com.betting.application.domain.utilities.Result;

import java.time.LocalDateTime;

public class BetDto {
    private Long userId;
    private Long matchId;
    private Long amount;
    private Result result;
    private double odd_1;
    private double odd_x;
    private double odd_2;
    private double amoutChangeAfterClosing;
    private LocalDateTime open;
    private LocalDateTime lastEdit;

    public BetDto(Long userId, Long matchId, Long amount, Result result, double odd_1, double odd_x, double odd_2, double amoutChangeAfterClosing, LocalDateTime open, LocalDateTime lastEdit) {
        this.userId = userId;
        this.matchId = matchId;
        this.amount = amount;
        this.result = result;
        this.odd_1 = odd_1;
        this.odd_x = odd_x;
        this.odd_2 = odd_2;
        this.amoutChangeAfterClosing = amoutChangeAfterClosing;
        this.open = open;
        this.lastEdit = lastEdit;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public Long getAmount() {
        return amount;
    }

    public Result getResult() {
        return result;
    }

    public double getOdd_1() {
        return odd_1;
    }

    public double getOdd_x() {
        return odd_x;
    }

    public double getOdd_2() {
        return odd_2;
    }

    public double getAmoutChangeAfterClosing() {
        return amoutChangeAfterClosing;
    }

    public LocalDateTime getOpen() {
        return open;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }
}

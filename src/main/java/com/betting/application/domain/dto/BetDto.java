package com.betting.application.domain.dto;

import com.betting.application.domain.utilities.Result;

import java.time.LocalDateTime;

public class BetDto {
    private Long betId;
    private Long userId;
    private Long matchId;
    private double amount;
    private Result userPredicton;
    private Result actualResult;
    private double odd_1;
    private double odd_x;
    private double odd_2;
    private double amoutChangeAfterClosing;
    private LocalDateTime open;
    private LocalDateTime eventTime;
    private LocalDateTime lastEdit;

    public BetDto(){}

    public BetDto(Long betId ,Long userId, Long matchId, double amount, Result userPredicton, Result actualResult, double odd_1, double odd_x, double odd_2, double amoutChangeAfterClosing, LocalDateTime open, LocalDateTime eventTime, LocalDateTime lastEdit) {
        this.betId = betId;
        this.userId = userId;
        this.matchId = matchId;
        this.amount = amount;
        this.userPredicton = userPredicton;
        this.actualResult = actualResult;
        this.odd_1 = odd_1;
        this.odd_x = odd_x;
        this.odd_2 = odd_2;
        this.amoutChangeAfterClosing = amoutChangeAfterClosing;
        this.open = open;
        this.eventTime = eventTime;
        this.lastEdit = lastEdit;
    }

    public Long getBetId() {
        return betId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public double getAmount() {
        return amount;
    }

    public Result getUserPredicton() {
        return userPredicton;
    }

    public Result getActualResult() {
        return actualResult;
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

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }
}

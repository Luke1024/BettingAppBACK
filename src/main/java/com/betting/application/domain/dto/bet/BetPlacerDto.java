package com.betting.application.domain.dto.bet;

import com.betting.application.domain.utilities.Result;

import java.util.Objects;

public class BetPlacerDto {
    private Long userId;
    private Long matchId;
    private double amount;
    private Result result;

    public BetPlacerDto(){}

    public BetPlacerDto(Long userId, Long matchId, double amount, Result result) {
        this.userId = userId;
        this.matchId = matchId;
        this.amount = amount;
        this.result = result;
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

    public Result getResult() {
        return result;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BetPlacerDto{" +
                "userId=" + userId +
                ", matchId=" + matchId +
                ", amount=" + amount +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BetPlacerDto)) return false;
        BetPlacerDto that = (BetPlacerDto) o;
        return Double.compare(that.amount, amount) == 0 &&
                userId.equals(that.userId) &&
                matchId.equals(that.matchId) &&
                result == that.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, matchId, amount, result);
    }
}

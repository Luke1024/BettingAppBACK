package com.betting.application.domain;

import com.betting.application.domain.utilities.Result;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bet {
    @Id
    @GeneratedValue
    private Long betId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SPORT_EVENT_ID")
    private SportEvent sportEvent;
    private double amount;
    private Result userPrediction;
    private Result actualResult;
    private double amoutChangeAfterClosing;
    private LocalDateTime open;
    private LocalDateTime lastEdit;
    private boolean archived;

    public Bet() {}

    public Bet(User user, SportEvent sportEvent, double amount, Result userPrediction) {
        this.user = user;
        this.sportEvent = sportEvent;
        this.amount = amount;
        this.userPrediction = userPrediction;
    }

    public Long getBetId() {
        return betId;
    }

    public User getUser() {
        return user;
    }

    public SportEvent getSportEvent() {
        return sportEvent;
    }

    public double getAmount() {
        return amount;
    }

    public Result getUserPrediction() {
        return userPrediction;
    }

    public Result getActualResult() {
        return actualResult;
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

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}

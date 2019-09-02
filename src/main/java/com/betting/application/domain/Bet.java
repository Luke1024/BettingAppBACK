package com.betting.application.domain;

import com.betting.application.domain.utilities.Result;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bet {
    @Id
    private Long betId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SPORT_EVENT_ID")
    private SportEvent sportEvent;
    private Long amount;
    private Result bet;
    private Result result;
    private double odd_1;
    private double odd_x;
    private double odd_2;
    private double amoutChangeAfterClosing;
    private LocalDateTime open;
    private LocalDateTime lastEdit;
    private boolean archived;
    private String winningTeam;
    private String losingTeam;

    public Bet() {}

    public Bet(Long betId, User user, SportEvent sportEvent, Long amount, Result bet, Result result, double odd_1, double odd_x, double odd_2, double amoutChangeAfterClosing, LocalDateTime open, LocalDateTime lastEdit, boolean archived, String winningTeam, String losingTeam) {
        this.betId = betId;
        this.user = user;
        this.sportEvent = sportEvent;
        this.amount = amount;
        this.bet = bet;
        this.result = result;
        this.odd_1 = odd_1;
        this.odd_x = odd_x;
        this.odd_2 = odd_2;
        this.amoutChangeAfterClosing = amoutChangeAfterClosing;
        this.open = open;
        this.lastEdit = lastEdit;
        this.archived = archived;
        this.winningTeam = winningTeam;
        this.losingTeam = losingTeam;
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

    public Long getAmount() {
        return amount;
    }

    public Result getBet() {
        return bet;
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

    public boolean isArchived() {
        return archived;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public String getLosingTeam() {
        return losingTeam;
    }
}

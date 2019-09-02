package com.betting.application.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SportEvent {
    @Id
    @Autowired
    private Long match_id;
    private Long country_id;
    private Long leaque_id;
    private String country_name;
    private String league_name;
    private LocalDateTime match_date_time;
    private String hometeam;
    private String awayteam;
    private double odd_1;
    private double odd_x;
    private double odd_2;
    private String match_status;
    @OneToMany(
            targetEntity = Bet.class,
            mappedBy = "sportEvent",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Bet> bets;

    public SportEvent(){}

    public SportEvent(Long match_id, Long country_id, Long leaque_id, String country_name, String league_name, LocalDateTime match_date_time, String hometeam, String awayteam, double odd_1, double odd_x, double odd_2, String match_status) {
        this.match_id = match_id;
        this.country_id = country_id;
        this.leaque_id = leaque_id;
        this.country_name = country_name;
        this.league_name = league_name;
        this.match_date_time = match_date_time;
        this.hometeam = hometeam;
        this.awayteam = awayteam;
        this.odd_1 = odd_1;
        this.odd_x = odd_x;
        this.odd_2 = odd_2;
        this.match_status = match_status;
        this.bets = new ArrayList<>();
    }

    public Long getMatch_id() {
        return match_id;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public Long getLeaque_id() {
        return leaque_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getLeague_name() {
        return league_name;
    }

    public LocalDateTime getMatch_date_time() {
        return match_date_time;
    }

    public String getHometeam() {
        return hometeam;
    }

    public String getAwayteam() {
        return awayteam;
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

    public String getMatch_status() {
        return match_status;
    }

    public List<Bet> getBets() {
        return bets;
    }
}

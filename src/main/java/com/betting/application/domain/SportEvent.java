package com.betting.application.domain;

import com.betting.application.domain.dto.OddsDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class SportEvent {
    @Id
    @NotNull
    private Long match_id;
    private Long country_id;
    private Long leaque_id;
    private String country_name;
    private String league_name;
    private LocalDateTime match_date_time;
    private String match_hometeam_name;
    private String match_awayteam_name;
    private double odd_1;
    private double odd_x;
    private double odd_2;
    private String match_status;

    public SportEvent(){}

    public SportEvent(Long match_id , Long country_id, Long leaque_id, String country_name, String league_name, LocalDateTime match_date_time, String match_hometeam_name, String match_awayteam_name, OddsDto oddsDto, String match_status) {
        this.match_id = match_id;
        this.country_id = country_id;
        this.leaque_id = leaque_id;
        this.country_name = country_name;
        this.league_name = league_name;
        this.match_date_time = match_date_time;
        this.match_hometeam_name = match_hometeam_name;
        this.match_awayteam_name = match_awayteam_name;
        this.odd_1 = oddsDto.getOdd_1();
        this.odd_x = oddsDto.getOdd_x();
        this.odd_2 = oddsDto.getOdd_2();
        this.match_status = match_status;
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

    public String getMatch_hometeam_name() {
        return match_hometeam_name;
    }

    public String getMatch_awayteam_name() {
        return match_awayteam_name;
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

    @Override
    public String toString() {
        return "SportEvent{" +
                ", match_id=" + match_id +
                ", country_id=" + country_id +
                ", leaque_id=" + leaque_id +
                ", country_name='" + country_name + '\'' +
                ", league_name='" + league_name + '\'' +
                ", match_date_time=" + match_date_time +
                ", match_hometeam_name='" + match_hometeam_name + '\'' +
                ", match_awayteam_name='" + match_awayteam_name + '\'' +
                ", odd_1=" + odd_1 +
                ", odd_x=" + odd_x +
                ", odd_2=" + odd_2 +
                ", match_status='" + match_status + '\'' +
                '}';
    }
}
